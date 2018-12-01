package xcx.calculator.rpn.output;

import java.math.BigDecimal;
import java.util.Stack;

public interface DisplayService {

    void print(Stack<BigDecimal> stack);
}
