package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class StationServiceTests {
    private StationService stationService;

    @BeforeEach
    public void 초기화() {
        stationService = new StationService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"잠실", "종로3가", "London Bridge"})
    public void station_추가_테스트(String stationName) {
        Station station = new Station(stationName);

        assertThatCode(() -> stationService.addStation(station))
                .doesNotThrowAnyException();

        List<Station> stations = StationRepository.stations();
        assertThat(stations.contains(station))
                .isTrue();
    }

    @Test
    public void station_삭제_테스트() {
        String stationName = "화랑대";
        Station station = new Station(stationName);
        StationRepository.addStation(station);

        assertThat(stationService.deleteStation(stationName))
                .isTrue();
    }

    @Test
    public void station_조회_테스트() {
        String stationName = "시청";
        Station station = new Station(stationName);
        StationRepository.addStation(station);

        assertThat(stationService.getStations().contains(station))
                .isTrue();
    }
}
