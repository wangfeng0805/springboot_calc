package xcx.calculator.rpn.david;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class AirCalcParser implements CalcParser  {
    public Stack<InputEntry> parseEntries(String line){
        Stack<InputEntry> entries = new Stack<InputEntry>();
        for (String inputValue : StringUtils.split(line.trim()," ")) {
            entries.push(new InputEntry(inputValue));
        }
        return entries;
    }
}
