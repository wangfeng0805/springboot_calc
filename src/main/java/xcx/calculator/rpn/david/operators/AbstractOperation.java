package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public abstract class AbstractOperation implements  Operation{

    BigDecimal num1 = null;
    BigDecimal num2 = null;

    private BigDecimal number;

    ParamStrategy paramStrategy;

    Operator opt;

    AbstractOperation(int paramsCountNeed,String optName){
        this.paramStrategy = new DynamicParamStrategy();
        this.paramStrategy.setParamsCountNeed(paramsCountNeed);
        this.paramStrategy.setOptName(optName);
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        if(paramStrategy != null)
        this.paramStrategy.undo(stack);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        BigDecimal firstNumber = stack.pop();;
        BigDecimal secNumber = stack.pop();

        BigDecimal calculationResult = firstNumber.add(secNumber);
        stack.push(calculationResult);

        this.getParamStrategy().setParamsCountNeed(2);
        this.getParamStrategy().setOptName(opt.name());
        this.getParamStrategy().init(firstNumber,secNumber);
        operationHistory.push(this);
    }
}
