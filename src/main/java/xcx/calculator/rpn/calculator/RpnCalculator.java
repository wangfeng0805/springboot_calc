package xcx.calculator.rpn.calculator;

import java.math.BigDecimal;
import java.util.Stack;

public interface RpnCalculator {
    Stack<BigDecimal> calculate(String[] keywordArray);
}
