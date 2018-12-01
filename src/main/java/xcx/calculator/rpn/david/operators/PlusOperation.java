package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public class PlusOperation extends AbstractOperation implements Operation {

    final Operator opt = Operator.PLUS;

    public PlusOperation() {
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        stack.push(getNum2());
        stack.push(getNum1());
    }

    PlusOperation(BigDecimal num1,BigDecimal num2){
        this.setNum1(num1);
        this.setNum2(num2);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        if(stack.size() < 2){
            throw new InsufficientParamsException(opt.name());
        }
        BigDecimal firstNumber = stack.pop();;
        BigDecimal secNumber = stack.pop();

        BigDecimal calculationResult = firstNumber.add(secNumber);
        stack.push(calculationResult);
        PlusOperation operation = new PlusOperation(firstNumber,secNumber);
        operationHistory.push(operation);
    }
}
