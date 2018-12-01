package xcx.calculator.rpn.david;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcx.calculator.rpn.david.operators.Operation;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

@Log4j2
@Service
public class RpnProcessorImpl implements RpnProcessor {

    private Stack<BigDecimal> stack;
    private Stack<Operation> operationHistory;
    @Autowired
    private CalcParser calcParser;

    {
        stack = new Stack<>();
        operationHistory = new Stack<>();
    }

    public Stack<BigDecimal> process(String line) {
        log.info("The input string:"+line);
        log.debug("Start process.");
        List<InputEntry> entries = calcParser.parseEntries(line);
        for(InputEntry entry:entries){
            try {
                entry.calc(stack,operationHistory);
            } catch (InsufficientParamsException e) {
                e.setEntryIndex(entry.getEntryIndex());
                log.error(e.getMessage());
            }
        }
        return stack;
    }
}
