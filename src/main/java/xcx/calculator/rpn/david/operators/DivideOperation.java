package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public class DivideOperation extends AbstractOperation{

    DivideOperation(){
        super(2,OperationFactory.DIVIDE.name());
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].divide(params[1]);
    }
}
