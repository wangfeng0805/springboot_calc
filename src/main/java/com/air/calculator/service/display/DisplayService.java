/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.service.display;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 13:00
 * @Description:
 */
public interface DisplayService {

    void display(Stack<BigDecimal> stack);
}
