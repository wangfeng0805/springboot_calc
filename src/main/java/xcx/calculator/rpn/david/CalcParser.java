package xcx.calculator.rpn.david;

import java.util.List;

public interface CalcParser {
    List<InputEntry> parseEntries(String line);
}
