package xcx.calculator.rpn.david;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class RpnCalcParser implements CalcParser  {
    private static final Logger logger = LoggerFactory.getLogger(RpnCalcParser.class);
    private int entryIndex = 0;
    public Stack<CalcEntry> parseEntries(String line){
        Stack<CalcEntry> entries = new Stack<CalcEntry>();
        for (String inputEntry : StringUtils.split(line.trim()," ")) {
            entryIndex ++;
            entries.push(new CalcEntry(inputEntry,entryIndex));
        }
        return entries;
    }
}
