package xcx.calculator.rpn.output;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

@Service
public class OutputServiceImpl implements OutputService {

    @Override
    public void print(Stack<BigDecimal> stack) {
        System.out.print("stack: [ ");
        for (BigDecimal stackElement : stack) {
            if (stackElement.scale() == 15) {
                stackElement = stackElement.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
            }

            System.out.print(stackElement + " ");
        }
        System.out.print("]\n");
//        System.out.println(">");
    }
}
