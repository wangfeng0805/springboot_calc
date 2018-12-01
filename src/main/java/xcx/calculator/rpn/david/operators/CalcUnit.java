package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public interface CalcUnit {
    void undo(Stack<BigDecimal> stack);
    void init(Stack<BigDecimal> stack) throws InsufficientParamsException;
    void setOptName(String optName);
    void setParamsCountNeed(int count);
    BigDecimal[] getParams();
}
