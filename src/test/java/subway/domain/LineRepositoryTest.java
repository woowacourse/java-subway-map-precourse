package subway.domain;

import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class LineRepositoryTest {

    @Test
    public void 초기값설정() {
        new DefaultSetting().defaultSetting();
    }

    @Test
    public void line_추가된다() {
        LineRepository.addLine(new Line("10호선"));
        assertEquals(LineRepository.findLineByName("10호선").getName(), "10호선");
    }

    @Test
    public void line_삭제된다() {
        LineRepository.addLine(new Line("삭제용호선"));
        assertTrue(LineRepository.deleteLineByName("삭제용호선"));
    }

    @Test
    public void line_가져온다() {
        assertEquals(LineRepository.findLineByName("2호선").getName(), "2호선");
    }
}
