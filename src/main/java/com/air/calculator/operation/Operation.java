/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

/**
 * @Auther: David
 * @Date: 2018-12-02 9:50
 * @Description: calc operation interface.
 *
 */
import com.air.calculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

public interface Operation {
    void undo(Stack<BigDecimal> stack);
    void calcTemplate(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException;
    BigDecimal processCoreCalc(BigDecimal[] params);
}
