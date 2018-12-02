package com.air.calculator.service.display;

/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 13:01
 * @Description: display the stack.
 */
@Service
public class AirDisplayService implements DisplayService {

    @Override
    public void display(Stack<BigDecimal> stack) {
        System.out.print("stack: ");

        for (BigDecimal stackElement : stack) {
            if (stackElement.scale() == 15) {
                stackElement = stackElement.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
            }
            System.out.print(stackElement + " ");
        }
        System.out.print("\n");
    }
}
