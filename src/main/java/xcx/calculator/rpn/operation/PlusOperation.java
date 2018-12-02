package xcx.calculator.rpn.operation;

import lombok.Data;
import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;

public class PlusOperation extends AbstractOperation{

    public PlusOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return params[0].add(params[1]);
    }
}
