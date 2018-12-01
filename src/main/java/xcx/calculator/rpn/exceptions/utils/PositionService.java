package xcx.calculator.rpn.exceptions.utils;

import java.util.Map;

public interface PositionService {

    Map<Integer, Integer> getPositionMap();

    void setPositionIndex(Integer position, String keyword);

    Integer getPositionIndex(Integer position);
}
