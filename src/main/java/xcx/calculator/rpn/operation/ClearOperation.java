package xcx.calculator.rpn.operation;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearOperation extends AbstractOperation{

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) {
        while(!stack.isEmpty()){
            stack.pop();
        }
        while(!operationHistory.isEmpty()){
            operationHistory.pop();
        }
    }
}
