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
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StationServiceTests {
    private StationService stationService;

    @BeforeEach
    public void 초기화() {
        stationService = new StationService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"잠실2", "종로3가2", "London Bridge2"})
    public void station_추가_테스트(String stationName) {
        Station station = new Station(stationName);

        assertThatCode(() -> stationService.addStation(station))
                .doesNotThrowAnyException();

        List<Station> stations = StationRepository.stations();
        assertThat(stations.contains(station))
                .isTrue();
    }

    @Test
    public void station_중복_추가_테스트() {
        String stationName = "판교";
        Station station = new Station(stationName);
        Station sameNameStation = new Station(stationName);

        assertThatCode(() -> stationService.addStation(station))
                .doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> stationService.addStation(sameNameStation));
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
    public void station_없는이름_삭제_예외발생_테스트() {
        String stationName = "없는 이름의 역";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> stationService.deleteStation(stationName));
    }

    @Test
    public void station_조회_테스트() {
        String stationName = "시청";
        Station station = new Station(stationName);
        StationRepository.addStation(station);

        assertThat(stationService.getStationNames().contains(stationName))
                .isTrue();
    }
}
