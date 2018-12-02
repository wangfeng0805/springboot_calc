/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.service;

import com.air.calculator.operation.Operation;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 13:05
 * @Description:
 */
public interface RpnProcessorService {
    Stack<BigDecimal> process(String line);
    void setStack(Stack<BigDecimal> stack);
    void setOperationHistory(Stack<Operation> optStack);
}
