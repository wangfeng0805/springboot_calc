package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

@Data
public class DoubleParamStrategy extends AbstractParamStrategy {

    @Override
    public boolean validateParams() throws InsufficientParamsException {
        if(params.length < 2){
            throw new InsufficientParamsException(optName);
        }else{
            return true;
        }
    }
}
