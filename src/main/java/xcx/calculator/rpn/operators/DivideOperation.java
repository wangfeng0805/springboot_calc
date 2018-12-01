package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class DivideOperation extends AbstractOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException {

        BigDecimal firstNumber = popNumberFromStack(stack, externalCommand);
        BigDecimal secondNumber = popSecondNumberFromStack(stack, firstNumber, externalCommand);
        BigDecimal calculationResult = secondNumber.divide(firstNumber, 15, RoundingMode.HALF_UP);

        stack.push(calculationResult);
        externalCommand.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        calculationResult
                )
        );
    }
}
