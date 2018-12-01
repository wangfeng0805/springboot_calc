package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.util.Stack;

public class MinusOperation extends AbstractOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) throws InsufficientParametersException {

        BigDecimal firstNumber = popNumberFromStack(stack, externalCommand);
        BigDecimal secondNumber = popSecondNumberFromStack(stack, firstNumber, externalCommand);
        BigDecimal calculationResult = secondNumber.subtract(firstNumber);

        stack.push(calculationResult);
        externalCommand.addInternalCommand(
                new InternalCommandImpl(
                        InternalCommandType.PUSH,
                        calculationResult
                )
        );
    }
}
