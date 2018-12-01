package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public class MultiplyOperation extends AbstractOperation implements Operation {

    MultiplyOperation(){
        super(2,OperationFactory.MULTIPLY.name());
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].multiply(params[1]);
    }
}
