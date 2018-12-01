package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

import static java.lang.StrictMath.sqrt;

public class SqrtOperation extends AbstractOperation implements Operation {
    @Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException {
        BigDecimal firstNumber = popNumberFromStack(stack, externalCommand);
        BigDecimal calculationResult = new BigDecimal(sqrt(firstNumber.doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.HALF_UP)
                .stripTrailingZeros();

        stack.push(calculationResult);
        externalCommand.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        calculationResult
                )
        );
    }
}
