package output;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubwayMapTest {

    @Test
    @DisplayName("저장된 데이터가 없을 때 예외 발생")
    void visualize() {
        SubwayMap subwayMap = new SubwayMap();
        subwayMap.visualize();
    }
}