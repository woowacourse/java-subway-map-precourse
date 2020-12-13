package subway.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.service.StationService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class SubwayMapControllerTests {
    private SubwayMapController subwayMapController;

    @BeforeEach
    public void 초기화() {
        subwayMapController = new SubwayMapController(null);
    }

    @ParameterizedTest
    @ValueSource(strings = {"잠실", "종로3가", "London Bridge"})
    public void station_추가_테스트(String stationName) {
        Station station = new Station(stationName);

        assertThatCode(() -> subwayMapController.registerStation(station))
                .doesNotThrowAnyException();

        List<Station> stations = StationRepository.stations();
        assertThat(stations.contains(station))
                .isTrue();
    }
}
