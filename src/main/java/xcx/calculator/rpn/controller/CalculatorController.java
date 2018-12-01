package xcx.calculator.rpn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.calculator.RpnCalculator;
import xcx.calculator.rpn.david.RpnProcessor;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.output.OutputService;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

@Component
public class CalculatorController {

    private OutputService outputService;
    private RpnCalculator rpnCalculator;

    @Autowired
    private RpnProcessor rpnProcessor;

    public CalculatorController(OutputService outputService, RpnCalculator rpnCalculator) {
        this.outputService = outputService;
        this.rpnCalculator = rpnCalculator;
    }

    public void process() throws InsufficientParametersException {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("$ >");

            String row = scanner.nextLine().trim();
            if (row.equals("exit")) {
                return;
            }
//            String[] keywordArray = row.split("\\s");
            Stack<BigDecimal> stack = rpnProcessor.process(row);

//            Stack<BigDecimal> stack = rpnCalculator.calculate(keywordArray);
            outputService.print(stack);
        }
    }




}
