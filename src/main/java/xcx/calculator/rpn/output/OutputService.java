package xcx.calculator.rpn.output;

import java.math.BigDecimal;
import java.util.Stack;

public interface OutputService {

    void print(Stack<BigDecimal> stack);
}
