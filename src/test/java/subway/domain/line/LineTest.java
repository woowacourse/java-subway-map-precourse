package subway.domain.line;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.exception.ShorterThanMinLineNameException;

@DisplayName("지하철 노선(Line)에 대한 테스트")
class LineTest {

    @DisplayName("지하철 노선 이름은 2글자 이상이어야 한다.")
    @Test
    void shorterThanMinLineNameException() {
        final String name = "a";

        assertThrows(ShorterThanMinLineNameException.class, () -> Line.from(name));
    }

    @DisplayName("지하철 노선을 생성할 수 있다.")
    @Test
    void create() {
        final String name = "test";
        final Line line = Line.from(name);

        assertNotNull(line);
    }
}