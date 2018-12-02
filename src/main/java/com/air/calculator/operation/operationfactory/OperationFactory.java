/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.operationfactory;

import com.air.calculator.operation.Operation;

/**
 * @Auther: David
 * @Date: 2018-12-02 14:26
 * @Description: the factory to create different operations.
 */
public interface OperationFactory {

    Operation createOperation();

}
