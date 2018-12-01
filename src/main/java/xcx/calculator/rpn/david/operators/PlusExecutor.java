package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public class PlusExecutor implements CalcExecutorInterface {

    @Override
    public void calcLogic(Stack<BigDecimal> stack) {

        BigDecimal firstNumber = stack.pop();;
        BigDecimal secNumber = stack.pop();

        BigDecimal calculationResult = firstNumber.add(secNumber);
        stack.push(calculationResult);

    }
}
