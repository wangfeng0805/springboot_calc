package xcx.calculator.rpn.david;

import lombok.Data;
import org.apache.commons.lang.math.NumberUtils;
import xcx.calculator.rpn.david.operators.Operation;
import xcx.calculator.rpn.david.operators.Operator;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class CalcEntry {
    private String entryValue;
    private int entryIndex;
    Operation opt;

    public CalcEntry(String entryValue, int entryIndex) {
        this.entryValue = entryValue;
        this.entryIndex = entryIndex;
        initOpt(entryValue);
    }

    private void initOpt(String entryValue){
        if(!NumberUtils.isNumber(entryValue)){
            if (!Operator.isValidOperator(entryValue)) {
                throw new RuntimeException("Invalid operator: " + entryValue);
            }
            this.setOpt(Operator.getOperation(entryValue));
        }else{
            this.setOpt(Operator.getPushOperation(new BigDecimal(entryValue)));
        }
    }

    public void calc(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException{
        this.opt.run(stack,operationHistory);
    }
}
