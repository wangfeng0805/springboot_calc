/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

import com.air.calculator.operation.calcUnit.CalcUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.StrictMath.sqrt;

/**
 * @Auther: David
 * @Date: 2018-12-02 10:42
 * @Description:
 */
public class SqrtOperation extends AbstractOperation{

    public SqrtOperation(CalcUnit calcUnit) {
        super(calcUnit);
    }

    @Override
    public BigDecimal processCoreCalc(BigDecimal[] params){
        return new BigDecimal(sqrt(params[0].doubleValue()), MathContext.DECIMAL128)
                .setScale(15, RoundingMode.DOWN)
                .stripTrailingZeros();
    }
}
