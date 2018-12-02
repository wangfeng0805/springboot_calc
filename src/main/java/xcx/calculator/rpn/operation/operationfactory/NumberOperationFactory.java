package xcx.calculator.rpn.operation.operationfactory;

import xcx.calculator.rpn.operation.Operation;
import xcx.calculator.rpn.operation.PushOperation;

import java.math.BigDecimal;

public class NumberOperationFactory implements OperationFactory {

    String entryValue;
    @Override
    public Operation createOperation(){
        return new PushOperation(new BigDecimal(entryValue));
    }

    public NumberOperationFactory(String entryValue){
        this.entryValue = entryValue;
    }
}
