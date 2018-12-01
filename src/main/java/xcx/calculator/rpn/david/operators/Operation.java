package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {
    void undo(Stack<BigDecimal> stack);
    void run(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException;
}
