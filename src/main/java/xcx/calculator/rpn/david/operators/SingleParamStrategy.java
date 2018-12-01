package xcx.calculator.rpn.david.operators;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public class SingleParamStrategy {
    BigDecimal param;

    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        stack.push(param);
    }
}
