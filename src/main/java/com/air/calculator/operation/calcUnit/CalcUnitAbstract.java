package com.air.calculator.operation.calcUnit;
/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

import lombok.Data;
import com.air.calculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 15:15
 * @Description: skeleton for Calc
 * @see com.air.calculator.operation.calcUnit.CalcUnit
 */
@Data
public class CalcUnitAbstract implements CalcUnit {

    BigDecimal[] params;
    String optName;
    int paramsCountNeed;

    public CalcUnitAbstract(String optName,int paramsCountNeed){
        this.optName = optName;
        this.paramsCountNeed = paramsCountNeed;
    }

    @Override
    public void undo(Stack<BigDecimal> stack){
        stack.pop();
        for(BigDecimal num:params){
            stack.push(num);
        }
    }

    @Override
    public BigDecimal[]  genParams(Stack<BigDecimal> stack) throws InsufficientParamsException {
        if(stack.size() < paramsCountNeed){
            throw new InsufficientParamsException(optName);
        }
        params = new BigDecimal[paramsCountNeed];
        for(int i = paramsCountNeed-1; i >= 0; i--){
            params[i] = stack.pop();
        }
        return params;
    }
}
