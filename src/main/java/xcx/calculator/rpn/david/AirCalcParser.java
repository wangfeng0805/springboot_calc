package xcx.calculator.rpn.david;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class AirCalcParser implements CalcParser  {
    private static final Logger logger = LoggerFactory.getLogger(AirCalcParser.class);
    private int entryIndex = 0;
    public Stack<InputEntry> parseEntries(String line){
        Stack<InputEntry> entries = new Stack<InputEntry>();
        for (String inputEntry : StringUtils.split(line.trim()," ")) {
            entries.push(new InputEntry(inputEntry,entryIndex++));
        }
        return entries;
    }

//    public InputEntry getEntry(String line){
//        Stack<InputEntry> entries = new Stack<InputEntry>();
//        for (String inputEntry : StringUtils.split(line.trim()," ")) {
//            entries.push(new InputEntry(inputEntry,entryIndex++));
//        }
//    }
}
