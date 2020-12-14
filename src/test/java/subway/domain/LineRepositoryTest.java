package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    @Test
    @DisplayName("존재하지 않는 노선을 입력하였을 때 예외 발생")
    void getLine() {
        LineRepository.getLine("거북선");
    }
}