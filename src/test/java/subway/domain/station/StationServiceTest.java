package subway.domain.station;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;
import subway.station.exception.CannotDeleteStationAlreadyAddedLineException;
import subway.station.service.StationService;

@DisplayName("지하철 역 비즈니스 로직(StationService)을 테스트 한다.")
public class StationServiceTest {

    final String STATION_1_NAME = "test station1";
    final Station station1 = Station.from(STATION_1_NAME);
    final Station station2 = Station.from("test station2");

    @BeforeEach
    void before() {
        StationRepository.save(station1);
        StationRepository.save(station2);
    }

    @AfterEach
    void after() {
        StationRepository.deleteAll();
    }

    @DisplayName("노선에 등록된 역은 삭제할 수 없다.")
    @Test
    void cannotDeleteStationAlreadyAddedLineException() {
        final Line line = Line.of("test line", station1, station2);
        LineRepository.save(line);

        assertThrows(CannotDeleteStationAlreadyAddedLineException.class,
            () -> StationService.deleteByName(STATION_1_NAME));
    }
}
