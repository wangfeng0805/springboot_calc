/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.calcUnit;

/**
 * @Auther: David
 * @Date: 2018-12-02 16:18
 * @Description: double param strategy for CalcUnit,
 * need push 2 original params to stack for undo action.
 * @see com.air.calculator.operation.calcUnit.CalcUnit
 */
public class CalcUnitWithDoubleParam extends CalcUnitAbstract {

    public CalcUnitWithDoubleParam(String optName){super(optName,2);}

}
