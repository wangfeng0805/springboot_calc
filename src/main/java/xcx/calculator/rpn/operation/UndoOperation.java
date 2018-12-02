package xcx.calculator.rpn.operation;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoOperation extends AbstractOperation{
    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) {
        Operation opt = operationHistory.pop();
        opt.undo(stack);
    }
}
