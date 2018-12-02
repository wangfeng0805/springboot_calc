package xcx.calculator.rpn.operation.calcUnit;

import xcx.calculator.rpn.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public interface CalcUnit {
    void undo(Stack<BigDecimal> stack);
    void initParams(Stack<BigDecimal> stack) throws InsufficientParamsException;
    BigDecimal[] getParams();
}
