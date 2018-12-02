package xcx.calculator.rpn.operation;

import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;

public class DivideOperation extends AbstractOperation{

    public DivideOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].divide(params[1]);
    }
}
