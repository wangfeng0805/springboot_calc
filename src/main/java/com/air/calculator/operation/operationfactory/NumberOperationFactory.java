/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.operationfactory;

import com.air.calculator.operation.PushOperation;
import com.air.calculator.operation.Operation;

import java.math.BigDecimal;

/**
 * @Auther: David
 * @Date: 2018-12-02 14:19
 * @Description: this is factory for the scenario which input entry is num.
 */
public class NumberOperationFactory implements OperationFactory {

    String entryValue;

    /**
     * Desc: create operation when input entry is num, currently only PushOperation,
     * will change the logic or split it when other operation added.
     *
     * @param: []
     * @return: com.air.calculator.operation.Operation
     * @auther: Wangfeng
     */
    @Override
    public Operation createOperation(){
        return new PushOperation(new BigDecimal(entryValue));
    }

    public NumberOperationFactory(String entryValue){
        this.entryValue = entryValue;
    }
}
