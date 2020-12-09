package subway.domain.station;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.exception.CannotFindStationByNameException;
import subway.domain.station.exception.DuplicateStationNameException;

@DisplayName("지하철 역 저장소(StationRepository)를 테스트 한다.")
class StationRepositoryTest {

    @AfterEach
    void after() {
        StationRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 역 이름이 등록될 수 없다.")
    @Test
    void duplicateStationNameException() {
        final String NAME = "test";
        final Station station = Station.from(NAME);
        StationRepository.addStation(station);

        assertThrows(DuplicateStationNameException.class, () -> {
            final Station newStation = Station.from(NAME);
            StationRepository.addStation(newStation);
        });
    }

    @DisplayName("지하철 역 저장소에 지하철 역을 등록할 수 있다.")
    @Test
    void addStation() {
        final String NAME = "test";
        final Station station = Station.from(NAME);

        StationRepository.addStation(station);

        final int EXPECT = 1;
        assertEquals(StationRepository.stations().size(), EXPECT);
    }

    @DisplayName("등록되지 않은 지하철 역은 조회할 수 없다.")
    @Test
    void cannotFindStationByNameException() {
        final String target = "test";

        assertThrows(CannotFindStationByNameException.class, () -> StationRepository.findByName(target));
    }

    @DisplayName("지하철 역 저장소에 존재하는 지하철을 이름으로 조회할 수 있다.")
    @Test
    void findStationByName() {
        final String NAME = "test";
        final Station station = Station.from(NAME);
        StationRepository.addStation(station);

        final Station foundStation = StationRepository.findByName(NAME);

        assertSame(foundStation, station);
    }
}