package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class StationTest {

    @BeforeEach
    public void 초기값설정() {
        new DefaultSetting().defaultSetting();
        StationRepository.addStation(new Station("서울역"));
        StationRepository.addStation(new Station("중앙역"));
    }

    @Test
    public void 역_생성된다() {
        Station station = new Station("왕십리역");
        assertEquals(station.getName(), "왕십리역");
    }

}
