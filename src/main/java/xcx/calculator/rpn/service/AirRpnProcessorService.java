package xcx.calculator.rpn.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import xcx.calculator.rpn.exception.InsufficientParamsException;
import xcx.calculator.rpn.operation.Operation;
import xcx.calculator.rpn.operation.OperationEnum;
import xcx.calculator.rpn.operation.operationfactory.CommandOperationFactory;
import xcx.calculator.rpn.operation.operationfactory.NumberOperationFactory;
import xcx.calculator.rpn.operation.operationfactory.OperationFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

@Log4j2
@Service
@Data
public class AirRpnProcessorService implements RpnProcessorService {

    private Stack<BigDecimal> stack = new Stack<>();
    private Stack<Operation> operationHistory = new Stack<>();

    public Stack<BigDecimal> process(String line) {
        log.info("The input string:"+line);
        int positionEntry = 1;
        List<InputEntry> entries = this.parseEntries(line);
        for(InputEntry entry:entries){
            try {
                entry.calc(stack,operationHistory);
            } catch (InsufficientParamsException e) {
                e.setEntryPosition(positionEntry);
                log.error(e.getMessage());
                break;
            }
            positionEntry += entry.getEntryValue().length();
            positionEntry++;
        }
        return stack;
    }

    private Stack<InputEntry> parseEntries(String line) {
        Stack<InputEntry> entries = new Stack<InputEntry>();
        for (String inputValue : StringUtils.split(line.trim(), " ")) {
            OperationFactory optFactory = getOperationFactory(inputValue);
            entries.push(new InputEntry(optFactory,inputValue));
        }
        return entries;
    }

    private OperationFactory getOperationFactory(String entryValue) {
        if (!NumberUtils.isNumber(entryValue)) {
            if (!OperationEnum.isValidOperator(entryValue)) {
                throw new RuntimeException("Invalid operator: " + entryValue);
            }
            return new CommandOperationFactory(entryValue);
        } else {
            return new NumberOperationFactory(entryValue);
        }
    }
}
