package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @BeforeEach
    public void 초기값설정() {
        new DefaultSetting().defaultSetting();
        StationRepository.addStation(new Station("서울역"));
        StationRepository.addStation(new Station("중앙역"));
    }

    @Test
    public void 노선_생성된다() {
        Line line = new Line("4호선");
        assertEquals(line.getName(), "4호선");
    }

    @Test
    public void 구간_추가된다() {

    }


}
