package xcx.calculator.rpn.operation;

public enum OperationEnum {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("sqrt"),
    CLEAR("clear"),
    UNDO("undo");

    private String optValue;

    OperationEnum(String value) {
        optValue = value;
    }

    public String getOptValue() {
        return optValue;
    }

    public static boolean isValidOperator(String operator) {
        for (OperationEnum validOperator : OperationEnum.values()) {
            if (validOperator.getOptValue().equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static OperationEnum getOptValue(String operator) {
        for (OperationEnum validOperator : OperationEnum.values()) {
            if (validOperator.getOptValue().equals(operator)) {
                return validOperator;
            }
        }
        return null;
    }
}
