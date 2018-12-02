package xcx.calculator.rpn.service;

import lombok.Data;
import xcx.calculator.rpn.exception.InsufficientParamsException;
import xcx.calculator.rpn.operation.Operation;
import xcx.calculator.rpn.operation.operationfactory.OperationFactory;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class InputEntry {

    OperationFactory optFactory;
    Operation opt;
    String entryValue;

    public InputEntry(OperationFactory optFactory,String entryValue) {
        this.optFactory = optFactory;
        this.entryValue = entryValue;
        opt = optFactory.createOperation();
    }

    public void calc(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException {
        opt.run(stack,operationHistory);
    }
}
