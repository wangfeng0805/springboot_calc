/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation.operationfactory;

import com.air.calculator.operation.*;
import com.air.calculator.operation.calcUnit.CalcUnit;
import com.air.calculator.operation.calcUnit.CalcUnitWithDoubleParam;
import com.air.calculator.operation.calcUnit.CalcUnitWithSingleParam;

/**
 * @Auther: David
 * @Date: 2018-12-02 14:20
 * @Description: this is factory for the scenario which input entry is operation:
 * + - * / sqrt undo clear,etc.
 */
public class CommandOperationFactory implements OperationFactory {

    String entryValue;

    public CommandOperationFactory(String entryValue){
        this.entryValue = entryValue;
    }

    /**
     * Desc: create operation when input entry is operation.
     *
     * @param: []
     * @return: com.air.calculator.operation.Operation
     * @auther: Wangfeng
     */
    @Override
    public Operation createOperation(){
        OperationEnum opt = OperationEnum.getOptValue(entryValue);
        CalcUnit calcUnit;
        switch (opt) {
            case PLUS:
                calcUnit = new CalcUnitWithDoubleParam(OperationEnum.PLUS.getOptValue());
                return new PlusOperation(calcUnit);
            case MINUS:
                calcUnit = new CalcUnitWithDoubleParam(OperationEnum.MINUS.getOptValue());
                return new MinusOperation(calcUnit);
            case MULTIPLY:
                calcUnit = new CalcUnitWithDoubleParam(OperationEnum.MULTIPLY.getOptValue());
                return new MultiplyOperation(calcUnit);
            case DIVIDE:
                calcUnit = new CalcUnitWithDoubleParam(OperationEnum.DIVIDE.getOptValue());
                return new DivideOperation(calcUnit);
            case SQRT:
                calcUnit = new CalcUnitWithSingleParam(OperationEnum.SQRT.getOptValue());
                return new SqrtOperation(calcUnit);
            case UNDO:
                return new UndoOperation();
            case CLEAR:
                return new ClearOperation();
            default:
                throw new RuntimeException("Invalid operate entry:" + entryValue);
        }
    }
}
