package xcx.calculator.rpn.commands;

import java.math.BigDecimal;

public interface InternalCommand {

    InternalCommandType getInternalCommandType();

    BigDecimal getNumber();
}
