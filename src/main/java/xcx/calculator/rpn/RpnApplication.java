package xcx.calculator.rpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import xcx.calculator.rpn.controller.CalculatorController;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class RpnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(RpnApplication.class, args);

		CalculatorController calculatorController = (CalculatorController) ctx.getBean("calculatorController");

		System.out.println("\n\n[RPN RpnCalculator] Enter a white-spaced list of numbers and operators then press enter:");
		try {
			calculatorController.process();
		} catch (InsufficientParametersException e) {
			e.printStackTrace();
		}

		ctx.close();
	}

}
