/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.calcUnit;

/**
 * @Auther: David
 * @Date: 2018-12-02 16:21
 * @Description: single param strategy for CalcUnit,
 * need push 1 original param into stack for undo action.
 * @see com.air.calculator.operation.calcUnit.CalcUnit
 */
public class CalcUnitWithSingleParam extends CalcUnitAbstract {

    public CalcUnitWithSingleParam(String optName){
        super(optName,1);
    }

}
