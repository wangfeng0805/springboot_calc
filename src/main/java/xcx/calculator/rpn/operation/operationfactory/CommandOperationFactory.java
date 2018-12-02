package xcx.calculator.rpn.operation.operationfactory;

import xcx.calculator.rpn.operation.calcUnit.CalcUnit;
import xcx.calculator.rpn.operation.calcUnit.CalcUnitWithDoubleParamStrategy;
import xcx.calculator.rpn.operation.calcUnit.CalcUnitWithSingleParamStrategy;
import xcx.calculator.rpn.operation.*;

public class CommandOperationFactory implements OperationFactory {

    String entryValue;

    public CommandOperationFactory(String entryValue){
        this.entryValue = entryValue;
    }

    @Override
    public Operation createOperation(){
        OperationEnum opt = OperationEnum.getOptValue(entryValue);
        CalcUnit calcUnit;
        switch (opt) {
            case PLUS:
                calcUnit = new CalcUnitWithDoubleParamStrategy(OperationEnum.PLUS.getOptValue());
                return new PlusOperation(calcUnit);
            case MINUS:
                calcUnit = new CalcUnitWithDoubleParamStrategy(OperationEnum.MINUS.getOptValue());
                return new MinusOperation(calcUnit);
            case MULTIPLY:
                calcUnit = new CalcUnitWithDoubleParamStrategy(OperationEnum.MULTIPLY.getOptValue());
                return new MultiplyOperation(calcUnit);
            case DIVIDE:
                calcUnit = new CalcUnitWithDoubleParamStrategy(OperationEnum.DIVIDE.getOptValue());
                return new DivideOperation(calcUnit);
            case SQRT:
                calcUnit = new CalcUnitWithSingleParamStrategy(OperationEnum.SQRT.getOptValue());
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
