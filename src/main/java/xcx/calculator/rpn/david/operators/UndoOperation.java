package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoOperation extends AbstractOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) {
        Operation opt = operationHistory.pop();
        opt.undo(stack);
    }
}
