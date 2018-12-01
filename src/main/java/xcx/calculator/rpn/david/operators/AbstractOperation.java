package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public abstract class AbstractOperation implements  Operation{

    CalcUnit calcUnit;

    AbstractOperation(){
    }

    AbstractOperation(int paramsCountNeed,String optName){
        this.calcUnit = new AirCalcUnit();
        this.calcUnit.setParamsCountNeed(paramsCountNeed);
        this.calcUnit.setOptName(optName);
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        if(calcUnit != null)
        this.calcUnit.undo(stack);
    }

    @Override
    public void run(Stack<BigDecimal> stack,Stack<Operation> operationHistory) throws InsufficientParamsException {
        this.calcUnit.init(stack);
        BigDecimal[] params = this.calcUnit.getParams();
        BigDecimal calculationResult = execCalc(params);
        stack.push(calculationResult);
        operationHistory.push(this);
    }

    @Override
    public BigDecimal execCalc(BigDecimal[] params){
        return null;
    }
}
