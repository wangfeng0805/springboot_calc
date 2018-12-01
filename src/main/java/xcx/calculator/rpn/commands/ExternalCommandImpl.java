package xcx.calculator.rpn.commands;

import java.util.Stack;

public class ExternalCommandImpl implements ExternalCommand {

    private Stack<InternalCommand> externalStack;

    public ExternalCommandImpl() {
        externalStack = new Stack<InternalCommand>();
    }

    public Stack<InternalCommand> getExternalStack() {
        return externalStack;
    }

    public void addInternalCommand(InternalCommand internalCommand) {
        externalStack.push(internalCommand);
    }

    public boolean isExternalStackEmpty() {
        return externalStack.empty();
    }

    public InternalCommand getLatestInternalCommand() {
        if (isExternalStackEmpty()) {
            return null;
        } else {
            return externalStack.pop();
        }
    }
}
