package xcx.calculator.rpn.commands;

import java.math.BigDecimal;

public class InternalCommandImpl implements InternalCommand {

    private InternalCommandType internalCommandType;

    private BigDecimal number;

    public InternalCommandImpl(InternalCommandType internalCommandType, BigDecimal number) {
        this.internalCommandType = internalCommandType;
        this.number = number;
    }

    public InternalCommandType getInternalCommandType() {
        return internalCommandType;
    }

    public BigDecimal getNumber() {
        return number;
    }
}
