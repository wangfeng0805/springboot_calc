package xcx.calculator.rpn.david;

import lombok.Data;
import org.apache.commons.lang.math.NumberUtils;
import xcx.calculator.rpn.david.operators.Operation;
import xcx.calculator.rpn.david.operators.OperationFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

@Data
public class InputEntry {
    private String entryValue;
    Operation opt;

    public InputEntry(String entryValue) {
        this.entryValue = entryValue;
        initOpt(entryValue);
    }

    private void initOpt(String entryValue){
        if(!NumberUtils.isNumber(entryValue)){
            if (!OperationFactory.isValidOperator(entryValue)) {
                throw new RuntimeException("Invalid operator: " + entryValue);
            }
            this.setOpt(OperationFactory.getOperation(entryValue));
        }else{
            this.setOpt(OperationFactory.getPushOperation(new BigDecimal(entryValue)));
        }
    }

    public void calc(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException{
        this.opt.run(stack,operationHistory);
    }
}
