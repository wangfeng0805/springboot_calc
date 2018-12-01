package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public class MinusOperation extends AbstractOperation{

    MinusOperation(){super(2,OperationFactory.MINUS.name());}

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].subtract(params[1]);
    }
}
