package xcx.calculator.rpn.david.operators;

import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public class PlusOperation extends AbstractOperation implements Operation {

    PlusOperation(int paramsCountNeed,String optName){
        super(paramsCountNeed,optName);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        BigDecimal firstNumber = stack.pop();;
        BigDecimal secNumber = stack.pop();

        BigDecimal calculationResult = firstNumber.add(secNumber);
        stack.push(calculationResult);

        this.getParamStrategy().init(firstNumber,secNumber);
        operationHistory.push(this);
    }
}
