package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public abstract class AbstractParamStrategy implements ParamStrategy {

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
    public void init(BigDecimal... initValues) throws InsufficientParamsException {
        if(params.length < paramsCountNeed){
            throw new InsufficientParamsException(optName);
        }
        int length = initValues.length;
        params = new BigDecimal[length];
        for(BigDecimal num:initValues){
            length = length - 1;
            params[length] = num;
        }
    }
}
