package xcx.calculator.rpn.operation;

import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.StrictMath.sqrt;

public class SqrtOperation extends AbstractOperation{

    public SqrtOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return new BigDecimal(sqrt(params[0].doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.DOWN)
                .stripTrailingZeros();
    }
}
