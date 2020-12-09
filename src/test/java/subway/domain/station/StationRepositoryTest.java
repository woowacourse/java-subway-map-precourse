package subway.domain.station;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.exception.CannotDeleteStationAlreadyAddedLineException;
import subway.domain.station.exception.CannotFindStationByNameException;
import subway.domain.station.exception.DuplicateStationNameException;

@DisplayName("지하철 역 저장소(StationRepository)를 테스트 한다.")
class StationRepositoryTest {

    @AfterEach
    void after() {
        StationRepository.deleteAllStation();
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

    @DisplayName("노선에 등록된 역은 삭제할 수 없다.")
    @Test
    void cannotDeleteStationAlreadyAddedLineException() {
        final String NAME = "test station1";
        final Station station1 = Station.from(NAME);
        final Station station2 = Station.from("test station2");
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        final Line line = Line.of("test line", station1, station2);
        LineRepository.addLine(line);

        assertThrows(CannotDeleteStationAlreadyAddedLineException.class,
            () -> StationRepository.deleteStationByName(NAME));
    }

    @DisplayName("지하철 역 저장소에서 지하철 역을 삭제할 수 있다.")
    @Test
    void deleteStation() {
        final String NAME = "test station1";
        final Station station1 = Station.from(NAME);
        final Station station2 = Station.from("test station2");
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);

        StationRepository.deleteStationByName(NAME);

        final int EXPECT = 1;
        assertEquals(StationRepository.stations().size(), EXPECT);
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
        final String NAME = "test";
        final Station station = Station.from(NAME);
        StationRepository.addStation(station);

        final Station foundStation = StationRepository.findByName(NAME);

        assertSame(foundStation, station);
    }
}