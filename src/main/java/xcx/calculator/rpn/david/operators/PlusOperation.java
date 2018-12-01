package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public class PlusOperation extends AbstractOperation implements Operation {

    PlusOperation(){super(2,OperationFactory.PLUS.name());}

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].add(params[1]);
    }
}
