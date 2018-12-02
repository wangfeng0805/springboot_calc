package xcx.calculator.rpn.operation;

import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;

public class MinusOperation extends AbstractOperation{

    public MinusOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].subtract(params[1]);
    }
}
