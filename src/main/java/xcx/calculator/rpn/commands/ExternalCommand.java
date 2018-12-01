package xcx.calculator.rpn.commands;

import java.util.Stack;

public interface ExternalCommand {

    void addInternalCommand(InternalCommand internalCommand);

    boolean isExternalStackEmpty();

    InternalCommand getLatestInternalCommand();

    Stack<InternalCommand> getExternalStack();
}
