package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommand;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;
import java.util.Stack;

public class UndoOperation {

    public static void run(Stack<BigDecimal> stack, Stack<ExternalCommand> commandHistory) throws InsufficientParametersException {
        ExternalCommand latestExternalCommand = commandHistory.pop();

        while (!latestExternalCommand.isExternalStackEmpty()) {
            InternalCommand latestInternalCommand = latestExternalCommand.getLatestInternalCommand();
            InternalCommandType type = latestInternalCommand.getInternalCommandType();
            BigDecimal number = latestInternalCommand.getNumber();

            if (InternalCommandType.POP.equals(type)) {
                stack.push(number);
            } else if (InternalCommandType.PUSH.equals(type)) {
                stack.pop();
            } else {
                throw new RuntimeException("Invalid type: " + type);
            }
        }
    }
}
