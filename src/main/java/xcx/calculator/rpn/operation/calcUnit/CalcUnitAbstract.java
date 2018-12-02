package xcx.calculator.rpn.operation.calcUnit;

import lombok.Data;
import xcx.calculator.rpn.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class CalcUnitAbstract implements CalcUnit {

    BigDecimal[] params;
    String optName;
    int paramsCountNeed;

    public CalcUnitAbstract(String optName,int paramsCountNeed){
        this.optName = optName;
        this.paramsCountNeed = paramsCountNeed;
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        for(BigDecimal num:params){
            stack.push(num);
        }
    }

    @Override
    public void initParams(Stack<BigDecimal> stack) throws InsufficientParamsException {
        if(stack.size() < paramsCountNeed){
            throw new InsufficientParamsException(optName);
        }
        params = new BigDecimal[paramsCountNeed];
        for(int i = paramsCountNeed-1; i >= 0; i--){
            params[i] = stack.pop();
        }
    }
}
