package xcx.calculator.rpn.operation;

import lombok.Data;
import xcx.calculator.rpn.exception.InsufficientParamsException;
import xcx.calculator.rpn.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public abstract class AbstractOperation implements  Operation{

    CalcUnit calcUnit;

    public AbstractOperation() {}

    public AbstractOperation(CalcUnit calcUnit) {
        this.calcUnit = calcUnit;
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        if(calcUnit != null)
        this.calcUnit.undo(stack);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        this.calcUnit.initParams(stack);
        BigDecimal[] params = this.calcUnit.getParams();
        BigDecimal calculationResult = execCalc(params);
        stack.push(calculationResult);
        operationHistory.push(this);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        throw new RuntimeException("Not support calc for this operator");
    }
}
