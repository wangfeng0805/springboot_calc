/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 10:50
 * @Description:
 */
@Data
public class PushOperation extends AbstractOperation {

    private BigDecimal number;

    public PushOperation(BigDecimal num){
        this.number = num;
    }

    @Override
    public void calcTemplate(Stack<BigDecimal> stack, Stack<Operation> operationHistory) {
        PushOperation operation = new PushOperation(this.getNumber());
        stack.push(this.getNumber());
        operationHistory.push(operation);
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
    }
}
