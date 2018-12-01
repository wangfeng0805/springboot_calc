package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.util.Stack;

public class AbstractOperation {

    private BigDecimal number;

    public BigDecimal popNumberFromStack(
            Stack<BigDecimal> stack,
            ExternalCommand externalCommand
    ) throws InsufficientParametersException {

        if (!stack.empty()) {
            number = stack.pop();

            externalCommand.addInternalCommand(
                    new InternalCommandImpl(
                            InternalCommandType.POP,
                            number
                    )
            );
        } else {
            throw new InsufficientParametersException();
        }

        return number;
    }

    public BigDecimal popSecondNumberFromStack(
            Stack<BigDecimal> stack,
            BigDecimal firstNumber,
            ExternalCommand externalCommand
    ) throws InsufficientParametersException {
        try {
            return popNumberFromStack(stack, externalCommand);
        } catch (InsufficientParametersException e) {
            stack.push(firstNumber);
            throw e;
        }
    }
}
