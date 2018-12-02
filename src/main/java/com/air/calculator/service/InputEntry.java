/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.service;

import com.air.calculator.operation.Operation;
import com.air.calculator.operation.operationfactory.OperationFactory;
import lombok.Data;
import com.air.calculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 13:50
 * @Description: the input entry represents the entry input by user:
 *   1 optFactory: set by entry's type, will create the operation for this entry.
 *   2 opt: the operation created by the optFactory.
 *   3 entryValue:the raw value of this entry input by user
 */
@Data
public class InputEntry {

    OperationFactory optFactory;
    Operation opt;
    String entryValue;

    public InputEntry(OperationFactory optFactory,String entryValue) {
        this.optFactory = optFactory;
        this.entryValue = entryValue;
        opt = optFactory.createOperation();
    }

    /**
     *
     * Desc: main process for calc of each entry,
     * it will delegate to operation's template method.
     *
     * @param: [stack, operationHistory]
     * @return: void
     * @auther: Wangfeng
     */
    public void calc(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException {
        opt.calcTemplate(stack,operationHistory);
    }
}
