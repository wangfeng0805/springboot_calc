package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.StrictMath.sqrt;

public class SqrtOperation extends AbstractOperation{

    SqrtOperation(){
        super(1,OperationFactory.SQRT.name());
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return new BigDecimal(sqrt(params[0].doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.HALF_UP)
                .stripTrailingZeros();
    }
}
