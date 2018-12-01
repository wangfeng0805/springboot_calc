package xcx.calculator.rpn.david;

import java.math.BigDecimal;
import java.util.Stack;

public interface RpnProcessor {
    Stack<BigDecimal> process(String line);
}
