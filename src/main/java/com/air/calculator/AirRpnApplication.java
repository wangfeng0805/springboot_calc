/*
 * Copyright (c) 2018-2018  WangFeng All Rights Reserved.@version: 1.0
 */

package com.air.calculator;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.air.calculator.controller.CalculatorController;

/**
 * @Auther: David
 * @Date: 2018-12-02 8:01
 * @Description:
 */
@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Log4j2
public class AirRpnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(AirRpnApplication.class, args);

		CalculatorController calculatorController = (CalculatorController) ctx.getBean("calculatorController");

		log.info("\n\n Plz input a list of numbers and operators separated by white spaced, then press enter to calc:");
		calculatorController.process();
		ctx.close();
	}

}
