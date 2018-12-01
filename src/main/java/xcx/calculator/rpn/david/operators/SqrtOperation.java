package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

import static java.lang.StrictMath.sqrt;

public class SqrtOperation extends AbstractOperation implements Operation {

    final Operator opt = Operator.SQRT;

    public SqrtOperation() {
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        stack.push(getNum1());
    }

    SqrtOperation(BigDecimal num1){
        this.setNum1(num1);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        if(stack.size() < 1){
            throw new InsufficientParamsException(opt.name());
        }
        BigDecimal firstNumber = stack.pop();;

//        BigDecimal calculationResult = firstNumber
        BigDecimal calculationResult = new BigDecimal(sqrt(firstNumber.doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.HALF_UP)
                .stripTrailingZeros();
        stack.push(calculationResult);
        SqrtOperation operation = new SqrtOperation(firstNumber);
        operationHistory.push(operation);
    }
}
