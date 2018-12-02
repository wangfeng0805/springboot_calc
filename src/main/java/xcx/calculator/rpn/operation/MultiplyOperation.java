package xcx.calculator.rpn.operation;

import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;

public class MultiplyOperation extends AbstractOperation{

    public MultiplyOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].multiply(params[1]);
    }

}
