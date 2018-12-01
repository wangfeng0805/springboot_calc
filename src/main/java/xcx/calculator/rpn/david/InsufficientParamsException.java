package xcx.calculator.rpn.david;

import lombok.Data;

@Data
public class InsufficientParamsException extends Exception {

    private String operator;

    private int entryIndex;

    public InsufficientParamsException(String operator) {
        this.operator = operator;
    }

    @Override
    public String getMessage() {
        return "operator " + this.getOperator() + " (position: " + this.getEntryIndex() + "): insufficient parameters";
    }
}
