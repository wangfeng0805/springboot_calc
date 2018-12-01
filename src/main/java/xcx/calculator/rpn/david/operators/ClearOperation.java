package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearOperation extends AbstractOperation{

    @Override
    public void run(Stack<BigDecimal> stack,Stack<xcx.calculator.rpn.david.operators.Operation> operationHistory) {
        while(!stack.isEmpty()){
            stack.pop();
        }
        while(!operationHistory.isEmpty()){
            operationHistory.pop();
        }
    }
}
