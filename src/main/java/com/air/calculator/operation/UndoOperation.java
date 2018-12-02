/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 10:50
 * @Description:
 */
public class UndoOperation extends AbstractOperation{
    @Override
    public void calcTemplate(Stack<BigDecimal> stack, Stack<Operation> operationHistory) {
        Operation opt = operationHistory.pop();
        opt.undo(stack);
    }
}
