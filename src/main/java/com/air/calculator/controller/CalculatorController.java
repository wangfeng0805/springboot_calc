/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.air.calculator.service.RpnProcessorService;
import com.air.calculator.service.display.DisplayService;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 9:13
 * @Description: main controller for rpn calc,
 * accept the input line, then process and calc it.
 */
@Component
public class CalculatorController implements BaseController{

    @Autowired
    private DisplayService displayService;

    @Autowired
    private RpnProcessorService rpnProcessor;

    @Override
    public void process(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("$ >");
            String row = scanner.nextLine().trim();
            if (row.equals("exit")) {
                return;
            }
            Stack<BigDecimal> stack = rpnProcessor.process(row);
            displayService.display(stack);
        }
    }




}
