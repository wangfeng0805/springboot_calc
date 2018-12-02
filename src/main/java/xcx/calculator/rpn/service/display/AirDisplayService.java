package xcx.calculator.rpn.service.display;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

@Service
public class AirDisplayService implements DisplayService {

    @Override
    public void display(Stack<BigDecimal> stack) {
        System.out.print("stack: ");
        for (BigDecimal stackElement : stack) {
            if (stackElement.scale() == 15) {
                stackElement = stackElement.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
            }

            System.out.print(stackElement + " ");
        }
        System.out.print("\n");
    }
}
