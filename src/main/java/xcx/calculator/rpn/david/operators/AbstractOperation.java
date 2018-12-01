package xcx.calculator.rpn.david.operators;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Stack;

@Data
public abstract class AbstractOperation implements  Operation{

    BigDecimal num1 = null;
    BigDecimal num2 = null;

    private BigDecimal number;

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        stack.push(this.num2);
        stack.push(this.num1);
    }
}
