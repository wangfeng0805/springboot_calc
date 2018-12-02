/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator.service;

import com.air.calculator.operation.Operation;
import com.air.calculator.operation.OperationEnum;
import com.air.calculator.operation.operationfactory.CommandOperationFactory;
import com.air.calculator.operation.operationfactory.NumberOperationFactory;
import com.air.calculator.operation.operationfactory.OperationFactory;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import com.air.calculator.exception.InsufficientParamsException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: David
 * @Date: 2018-12-02 13:10
 * @Description: process the input line.
 */
@Log4j2
@Service
@Data
public class AirRpnProcessorService implements RpnProcessorService {

    private Stack<BigDecimal> stack = new Stack<>();
    private Stack<Operation> operationHistory = new Stack<>();

    /**
     *
     * Desc:process input line,parse the line firstly, then loop the etnries:
     * store the num to stack or calc the num depends on the type of entry's value.
     *
     * @param: [line]
     * @return: java.util.Stack<java.math.BigDecimal>
     * @auther: Wangfeng
     */
    public Stack<BigDecimal> process(String line) {
        log.info("The input string:"+line);
        //define the first position as 1.
        int positionEntry = 1;
        List<InputEntry> entries = this.parseEntries(line);
        for(InputEntry entry:entries){
            try {
                log.debug("current entry:"+entry.entryValue);
                entry.calc(stack,operationHistory);
            } catch (InsufficientParamsException e) {
                e.setEntryPosition(positionEntry);
                log.error(e.getMessage());
                break;
            }
            //add the space and this entry, so +2.
            positionEntry += 2;
        }
        return stack;
    }

    /**
     *
     * Desc: parse input line, set operation factory by type of entry's value:
     * 1 number operation factory: input is num,currently this factory only creates PushOperation.
     * 2 command operation factory: input is operation,like:+ - * / sqrt undo clear,
     *    then the factory will creates different operations respectively later.
     *
     * @param: [line]
     * @return: java.util.Stack<com.air.calculator.service.InputEntry>
     * @auther: Wangfeng
     */
    private Stack<InputEntry> parseEntries(String line) {
        Stack<InputEntry> entries = new Stack<InputEntry>();
        for (String inputValue : StringUtils.split(line.trim(), " ")) {
            OperationFactory optFactory = getOperationFactory(inputValue);
            entries.push(new InputEntry(optFactory,inputValue));
        }
        return entries;
    }

    /**
     *
     * Desc: get operation factory by type of entry's value.
     *
     * @param: [entryValue]
     * @return: com.air.calculator.operation.operationfactory.OperationFactory
     * @auther: Wangfeng
     */
    private OperationFactory getOperationFactory(String entryValue) {
        if (!NumberUtils.isNumber(entryValue)) {
            if (!OperationEnum.isValidOperator(entryValue)) {
                throw new RuntimeException("Invalid operator: " + entryValue);
            }
            return new CommandOperationFactory(entryValue);
        } else {
            return new NumberOperationFactory(entryValue);
        }
    }
}
