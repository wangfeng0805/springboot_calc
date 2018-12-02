/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.calcUnit;

import com.air.calculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 15:09
 * @Description: basic calc unit,including:
 * 1 The params for this calculator.
 * 2 The logic for undo action: how to pop current top value from stack,
 *   and push original params into stack.
 */
public interface CalcUnit {
    void undo(Stack<BigDecimal> stack);
    BigDecimal[] genParams(Stack<BigDecimal> stack) throws InsufficientParamsException;
}
