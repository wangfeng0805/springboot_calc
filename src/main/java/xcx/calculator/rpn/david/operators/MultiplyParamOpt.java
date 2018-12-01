package xcx.calculator.rpn.david.operators;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class MultiplyParamOpt {

    List<BigDecimal> argList = new ArrayList<>();

    public void initArgs(BigDecimal... args){
        for(BigDecimal arg:args){
            argList.add(arg);
        }
    }
}
