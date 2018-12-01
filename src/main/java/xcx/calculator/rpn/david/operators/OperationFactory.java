package xcx.calculator.rpn.david.operators;

import java.math.BigDecimal;

public enum OperationFactory {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    SQRT("sqrt"),
    CLEAR("clear"),
    UNDO("undo");

    private String operator;

    OperationFactory(String value) {
        operator = value;
    }

    public String getOperator() {
        return operator;
    }

    public static boolean isValidOperator(String operator) {

        for (OperationFactory validOperator : OperationFactory.values()) {
            if (validOperator.getOperator().equals(operator)) {
                return true;
            }
        }
        return false;
    }

    public static OperationFactory getOperator(String operator) {
        for (OperationFactory validOperator : OperationFactory.values()) {
            if (validOperator.getOperator().equals(operator)) {
                return validOperator;
            }
        }
        return null;
    }

    public static Operation getPushOperation(BigDecimal pushValue){
        return new PushOperation(pushValue);
    }
    public static Operation getOperation(String operator) {
        OperationFactory opt = getOperator(operator);
        switch (opt) {
            case PLUS:
                return new PlusOperation();
            case UNDO:
                return new UndoOperation();
            case MINUS:
                return new MinusOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            case DIVIDE:
                return new DivideOperation();
            case CLEAR:
                return new ClearOperation();
            case SQRT:
                return new SqrtOperation();
            default:
                throw new RuntimeException("Invalid operator:" + operator);
        }
    }
}
