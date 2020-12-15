package subway.domain;

import org.junit.jupiter.api.Test;
import subway.util.DefaultSetting;

import static org.junit.jupiter.api.Assertions.*;

public class StationRepositoryTest {

    @Test
    public void 초기값_설정() {
        new DefaultSetting().defaultSetting();
    }

    @Test
    public void station_추가된다() {
        StationRepository.addStation(new Station("서울역"));
        assertEquals(StationRepository.findStationByName("서울역").getName(), "서울역");
    }

    @Test
    public void station_삭제된다() {
        StationRepository.addStation(new Station("서울역"));
        assertTrue(StationRepository.deleteStation("서울역"));
    }

    @Test
    public void station_가져온다() {
        Station station = StationRepository.findStationByName("양재역");
        assertEquals(station.getName(), "양재역");
    }
}
