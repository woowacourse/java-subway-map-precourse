package subway.domain.station;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.CannotFindStationByNameException;
import subway.station.exception.DuplicateStationNameException;

@DisplayName("지하철 역 저장소(StationRepository)를 테스트 한다.")
class StationRepositoryTest {

    final String STATION_1_NAME = "test station1";
    final Station station1 = Station.from(STATION_1_NAME);
    final Station station2 = Station.from("test station2");
    final int SIZE = 2;

    @BeforeEach
    void before() {
        StationRepository.save(station1);
        StationRepository.save(station2);
    }

    @AfterEach
    void after() {
        StationRepository.deleteAll();
    }

    @DisplayName("중복된 지하철 역 이름이 등록될 수 없다.")
    @Test
    void duplicateStationNameException() {
        assertThrows(DuplicateStationNameException.class, () -> {
            final Station newStation = Station.from(STATION_1_NAME);
            StationRepository.save(newStation);
        });
    }

    @DisplayName("지하철 역 저장소에 지하철 역을 등록할 수 있다.")
    @Test
    void addStation() {
        final Station station = Station.from("test");

        StationRepository.save(station);

        final int EXPECT = SIZE + 1;
        assertEquals(StationRepository.findAll().size(), EXPECT);
    }

    @DisplayName("지하철 역 저장소에서 지하철 역을 삭제할 수 있다.")
    @Test
    void deleteStation() {
        StationRepository.delete(station1);

        final int EXPECT = SIZE - 1;
        assertEquals(StationRepository.findAll().size(), EXPECT);
    }

    @DisplayName("등록되지 않은 지하철 역은 조회할 수 없다.")
    @Test
    void cannotFindStationByNameException() {
        final String target = "test";

        assertThrows(CannotFindStationByNameException.class,
            () -> StationRepository.findByName(target));
    }

    @DisplayName("지하철 역 저장소에 존재하는 지하철을 이름으로 조회할 수 있다.")
    @Test
    void findStationByName() {
        final Station foundStation = StationRepository.findByName(STATION_1_NAME);

        assertSame(foundStation, station1);
    }
}