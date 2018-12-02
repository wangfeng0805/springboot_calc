/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

import com.air.calculator.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;

/**
 * @Auther: David
 * @Date: 2018-12-02 10:35
 * @Description:
 */
public class DivideOperation extends AbstractOperation{

    public DivideOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal processCoreCalc(BigDecimal[] params){
        return params[0].divide(params[1]);
    }
}
