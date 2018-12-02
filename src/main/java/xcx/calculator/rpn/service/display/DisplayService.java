package xcx.calculator.rpn.service.display;

import java.math.BigDecimal;
import java.util.Stack;

public interface DisplayService {

    void display(Stack<BigDecimal> stack);
}
