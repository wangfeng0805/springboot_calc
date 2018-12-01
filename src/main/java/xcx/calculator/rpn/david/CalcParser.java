package xcx.calculator.rpn.david;

import java.util.List;

public interface CalcParser {
    List<CalcEntry> parseEntries(String line);
}
