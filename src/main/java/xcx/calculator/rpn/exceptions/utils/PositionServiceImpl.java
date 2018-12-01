package xcx.calculator.rpn.exceptions.utils;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PositionServiceImpl implements PositionService {

    private Map<Integer, Integer> positionMap;

    public PositionServiceImpl() {
        positionMap = new HashMap<>();
    }

    public Map<Integer, Integer> getPositionMap() {
        return positionMap;
    }

    public void setPositionIndex(Integer position, String keyword) {
        Integer keywordLength = keyword.length();
        Integer latestIndex;
        Integer positionIndex = 1;
        if (position > 0) {
            latestIndex = positionMap.get(position - 1) + 1;
            positionIndex = latestIndex + keywordLength;
        }

        positionMap.put(position, positionIndex);
    }

    public Integer getPositionIndex(Integer position) {
        return positionMap.get(position);
    }
}
