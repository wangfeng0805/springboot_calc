package xcx.calculator.rpn.exceptions;

import xcx.calculator.rpn.operators.Operator;

public class InsufficientParametersException extends Exception {

    private Operator operator = null;

    private int positionIndex = -1;

    public InsufficientParametersException() {
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setPositionIndex(int index) {
        this.positionIndex = index;
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    @Override
    public String getMessage() {

        return "operator " + this.operator.getOperator() + " (position: " + this.getPositionIndex() + "): insufficient parameters";
    }
}
