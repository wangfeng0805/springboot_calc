package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class PushOperation extends AbstractOperation implements Operation {

    PushOperation(BigDecimal num){
        this.setNumber(num);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) {
        PushOperation operation = new PushOperation(this.getNumber());
        stack.push(this.getNumber());
        operationHistory.push(operation);
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
    }
}
