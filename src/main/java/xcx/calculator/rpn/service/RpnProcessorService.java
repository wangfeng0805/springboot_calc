package xcx.calculator.rpn.service;

import xcx.calculator.rpn.operation.Operation;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Stack;

public interface RpnProcessorService {
    Stack<BigDecimal> process(String line);
    void setStack(Stack<BigDecimal> stack);
    void setOperationHistory(Stack<Operation> optStack);
}
