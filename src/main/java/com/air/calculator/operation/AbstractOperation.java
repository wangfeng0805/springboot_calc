/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.operation;

import lombok.Data;
import com.air.calculator.exception.InsufficientParamsException;
import com.air.calculator.operation.calcUnit.CalcUnit;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 10:37
 * @Description: skeleton for operation
 */
@Data
@Log4j2
public abstract class AbstractOperation implements  Operation{

    CalcUnit calcUnitDelegate;

    public AbstractOperation() {}

    public AbstractOperation(CalcUnit calcUnitDelegate) {
        this.calcUnitDelegate = calcUnitDelegate;
    }

    /**
     *
     * Desc:The undo action will use delegate classes for implementation
     * according to different operation type:single param or double params.
     *
     * @param: [stack]
     * @return: void
     * @auther: Wangfeng
     */
    @Override
    public void undo(Stack<BigDecimal> stack){
        if(calcUnitDelegate != null){
            this.calcUnitDelegate.undo(stack);
        }
        else{
            throw new RuntimeException("Unsupport undo action for this operator");
        }
    }
    /**
     *
     * Desc:use template here as most operation has same steps for calc:+ - * / sqrt,
     * but those operations need override this method:clear undo, as the logic are different.
     *
     * @param: [stack, operationHistory]
     * @return: void
     * @auther: Wangfeng
     */
    @Override
    public void calcTemplate(Stack<BigDecimal> stack, Stack<Operation> operationHistory) throws InsufficientParamsException {
        log.debug("Start calcTemplate.");
        BigDecimal[] params = this.calcUnitDelegate.genParams(stack);
        BigDecimal calculationResult = processCoreCalc(params);
        log.debug("Inside calcTemplate,the calculationResult:"+calculationResult);
        stack.push(calculationResult);
        operationHistory.push(this);
    }

    /**
     *
     * Desc:core calc logic for different operation,
     * the concrete classed need provide the implementation,otherwise will throw exception..
     *
     * @param: [params]
     * @return: java.math.BigDecimal
     * @auther: Wangfeng
     */
    @Override
    public BigDecimal processCoreCalc(BigDecimal[] params){
        throw new RuntimeException("Unsupport calc action for this operator");
    }
}
