package xcx.calculator.rpn.calculator;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;
import xcx.calculator.rpn.commands.ExternalCommand;
import xcx.calculator.rpn.commands.ExternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandImpl;
import xcx.calculator.rpn.commands.InternalCommandType;
import xcx.calculator.rpn.exceptions.InsufficientParametersException;
import xcx.calculator.rpn.exceptions.utils.PositionService;
import xcx.calculator.rpn.operators.Operator;
import xcx.calculator.rpn.operators.UndoOperation;

import java.math.BigDecimal;
import java.util.Stack;

@Component
public class RpnCalculatorImpl implements RpnCalculator {

    private Stack<BigDecimal> stack;
    private Stack<ExternalCommand> commandHistory;
    private PositionService positionService;

    public RpnCalculatorImpl(PositionService positionService) {
        stack = new Stack<>();
        commandHistory = new Stack<>();
        this.positionService = positionService;
    }

    public Stack<BigDecimal> calculate(String[] keywordArray) {

        int position = 0;
        boolean enableCommandHistory = true;

        for (String keyword : keywordArray) {
            positionService.setPositionIndex(position, keyword);
            ExternalCommand externalCommand = new ExternalCommandImpl();

            if (NumberUtils.isNumber(keyword)) {

                BigDecimal bigDecimalKeyword = new BigDecimal(keyword);
                stack.push(bigDecimalKeyword);
                externalCommand.addInternalCommand(
                        new InternalCommandImpl(
                                InternalCommandType.PUSH,
                                bigDecimalKeyword
                        )
                );

            } else {
                if (!Operator.isValidOperator(keyword)) {
                    throw new RuntimeException("Invalid operator: " + keyword);
                }

                try {
                    if (Operator.getOperator(keyword).equals(Operator.UNDO)) {
                        enableCommandHistory = false;
                        UndoOperation.run(stack, commandHistory);
                    } else {
                        Operator.getOperation(Operator.getOperator(keyword)).run(stack, externalCommand);
                    }
                } catch (InsufficientParametersException e) {
                    e.setOperator(Operator.getOperator(keyword));
                    e.setPositionIndex(positionService.getPositionIndex(position));
                    System.err.println(e.getMessage());
                    System.err.flush();
                    break;
                }
            }

            if (enableCommandHistory) {
                commandHistory.push(externalCommand);
            }

            position++;
        }

        return stack;
    }

}
