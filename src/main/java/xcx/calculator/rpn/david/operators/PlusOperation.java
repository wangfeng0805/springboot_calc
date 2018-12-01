package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public class PlusOperation extends AbstractOperation{

    PlusOperation(){super(2,OperationFactory.PLUS.getOptValue());}

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].add(params[1]);
    }
}
