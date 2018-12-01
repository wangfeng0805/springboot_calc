package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class AirCalcUnit implements CalcUnit {

    BigDecimal[] params;
    String optName;
    int paramsCountNeed;

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        for(BigDecimal num:params){
            stack.push(num);
        }
    }

    @Override
    public void init(Stack<BigDecimal> stack) throws InsufficientParamsException {
        if(stack.size() < paramsCountNeed){
            throw new InsufficientParamsException(optName);
        }
        params = new BigDecimal[paramsCountNeed];
        for(int i = paramsCountNeed-1; i >= 0; i--){
            params[i] = stack.pop();
        }
    }
}
