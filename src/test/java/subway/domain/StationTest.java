package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class StationTest {

    Station station;

    @BeforeEach
    public void 초기값설정() {
        new DefaultSetting().defaultSetting();
        StationRepository.addStation(new Station("서울역"));
        StationRepository.addStation(new Station("중앙역"));
        station = new Station("서울숲역");
    }

    @Test
    public void 역_생성된다() {
        assertEquals(station.getName(), "서울숲역");
    }

    @Test
    public void isRemovable_테스트() {
        assertTrue(station.isRemovable());
    }

    @Test
    public void increaseCount_테스트() {
        station.increaseCount();
        assertEquals(station.getCount(), 1);
    }

    @Test
    public void decreaseCount_테스트() {
        station.decreaseCount();
        assertEquals(station.getCount(), -1);
    }

}
