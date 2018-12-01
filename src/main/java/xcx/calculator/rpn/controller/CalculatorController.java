package xcx.calculator.rpn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.david.RpnProcessor;
import xcx.calculator.rpn.output.DisplayService;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

@Component
public class CalculatorController {

    @Autowired
    private DisplayService displayService;

    @Autowired
    private RpnProcessor rpnProcessor;

    public void process(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("$ >");
            String row = scanner.nextLine().trim();
            if (row.equals("exit")) {
                return;
            }
            Stack<BigDecimal> stack = rpnProcessor.process(row);
            displayService.print(stack);
        }
    }




}
