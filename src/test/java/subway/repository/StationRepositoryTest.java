package subway.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;

import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {

    @Test
    @DisplayName("역 이름으로 역을 조회할 수 있다")
    public void findStationByname() throws Exception{
        StationRepository.addStation(new Station("bepoz"));
        Station findStation = StationRepository.findStationByName("bepoz");
        assertEquals(findStation.getName(),"bepoz");
    }

    @Test
    @DisplayName("역이 없을 때에는 역 이름으로 역을 조회할 수 없다")
    public void findStationBynameWhenNull() throws Exception{
        Station findStation = StationRepository.findStationByName("bepoz");
        assertNull(findStation);
    }

}