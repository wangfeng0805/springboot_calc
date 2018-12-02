package xcx.calculator.rpn.operation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class PushOperation extends AbstractOperation {

    private BigDecimal number;

    public PushOperation(BigDecimal num){
        this.number = num;
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
