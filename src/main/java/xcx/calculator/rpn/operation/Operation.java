package xcx.calculator.rpn.operation;

import xcx.calculator.rpn.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {
    void undo(Stack<BigDecimal> stack);
    void run(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException;
    BigDecimal execCalc(BigDecimal[] params);
}
