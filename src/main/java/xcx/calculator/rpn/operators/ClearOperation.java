package xcx.calculator.rpn.operators;

import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;

import java.math.BigDecimal;
import java.util.Stack;

public class ClearOperation implements Operation {

    @Override
    public void run(Stack<BigDecimal> stack, ExternalCommand externalCommand) {
        while (!stack.empty()) {
            BigDecimal number = stack.pop();
            externalCommand.addInternalCommand(
                    new InternalCommandImpl(
                            InternalCommandType.POP,
                            number
                    )
            );
        }
    }
}
