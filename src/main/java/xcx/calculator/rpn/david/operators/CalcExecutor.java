package xcx.calculator.rpn.david.operators;

import lombok.Data;
import xcx.calculator.rpn.david.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class CalcExecutor {

    private CalcExecutorInterface calcExe;

    public void exec(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException {
        calcExe.calcLogic(stack);

    }

}
