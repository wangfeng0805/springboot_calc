package xcx.calculator.rpn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.service.RpnProcessorService;
import xcx.calculator.rpn.service.display.DisplayService;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

@Component
public class CalculatorController implements BaseController{

    @Autowired
    private DisplayService displayService;

    @Autowired
    private RpnProcessorService rpnProcessor;

    @Override
    public void process(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("$ >");
            String row = scanner.nextLine().trim();
            if (row.equals("exit")) {
                return;
            }
            Stack<BigDecimal> stack = rpnProcessor.process(row);
            displayService.display(stack);
        }
    }




}
