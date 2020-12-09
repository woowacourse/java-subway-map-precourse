package subway.domain.station;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.exception.CannotDeleteStationAlreadyAddedLineException;
import subway.domain.station.exception.CannotFindStationByNameException;
import subway.domain.station.exception.DuplicateStationNameException;

@DisplayName("지하철 역 저장소(StationRepository)를 테스트 한다.")
class StationRepositoryTest {

    final String STATION_1_NAME = "test station1";
    final Station station1 = Station.from(STATION_1_NAME);
    final Station station2 = Station.from("test station2");
    final int SIZE = 2;

    @BeforeEach
    void before() {
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
    }

    @AfterEach
    void after() {
        StationRepository.deleteAllStation();
    }

    @DisplayName("중복된 지하철 역 이름이 등록될 수 없다.")
    @Test
    void duplicateStationNameException() {
        assertThrows(DuplicateStationNameException.class, () -> {
            final Station newStation = Station.from(STATION_1_NAME);
            StationRepository.addStation(newStation);
        });
    }

    @DisplayName("지하철 역 저장소에 지하철 역을 등록할 수 있다.")
    @Test
    void addStation() {
        final Station station = Station.from("test");

        StationRepository.addStation(station);

        final int EXPECT = SIZE + 1;
        assertEquals(StationRepository.stations().size(), EXPECT);
    }

    @DisplayName("노선에 등록된 역은 삭제할 수 없다.")
    @Test
    void cannotDeleteStationAlreadyAddedLineException() {
        final Line line = Line.of("test line", station1, station2);
        LineRepository.addLine(line);

        assertThrows(CannotDeleteStationAlreadyAddedLineException.class,
            () -> StationRepository.deleteStationByName(STATION_1_NAME));
    }

    @DisplayName("지하철 역 저장소에서 지하철 역을 삭제할 수 있다.")
    @Test
    void deleteStation() {
        StationRepository.deleteStationByName(STATION_1_NAME);

        final int EXPECT = SIZE - 1;
        assertEquals(StationRepository.stations().size(), EXPECT);
    }

    @DisplayName("등록되지 않은 지하철 역은 조회할 수 없다.")
    @Test
    void cannotFindStationByNameException() {
        final String target = "test";

        assertThrows(CannotFindStationByNameException.class,
            () -> StationRepository.findStationByName(target));
    }

    @DisplayName("지하철 역 저장소에 존재하는 지하철을 이름으로 조회할 수 있다.")
    @Test
    void findStationByName() {
        final Station foundStation = StationRepository.findStationByName(STATION_1_NAME);

        assertSame(foundStation, station1);
    }
}