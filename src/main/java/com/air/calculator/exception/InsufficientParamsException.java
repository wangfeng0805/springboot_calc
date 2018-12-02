package com.air.calculator.exception;

import lombok.Data;

/**
 * @Auther: David
 * @Date: 2018-12-02 9:01
 * @Description: exception happens when not enough parameters for calc.
 */
@Data
public class InsufficientParamsException extends Exception {

    private String operator;

    private int entryPosition;

    public InsufficientParamsException(String operator) {
        this.operator = operator;
    }

    @Override
    public String getMessage() {
        return "operator " + this.getOperator() + " (position: " + this.getEntryPosition() + "): insufficient parameters";
    }
}
