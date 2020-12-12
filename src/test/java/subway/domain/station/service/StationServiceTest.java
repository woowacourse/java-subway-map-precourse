package subway.domain.station.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class StationServiceTest {

    @AfterEach
    void tearDown() {
        StationRepository.deleteAll();
    }

    @DisplayName("station을 추가하는 기능을 테스트한다")
    @Test
    void testRegisterStation() {
        //given
        Station station = new Station("강남역");

        //when
        StationService.registerStation(station);

        //thent
        List<Station> stations = StationRepository.stations();
        assertThat(stations)
                .extracting("name", String.class)
                .contains("강남역");
    }

    @DisplayName("중복되는 이름의 station을 추가하면 예외를 발생시킨다.")
    @Test
    void testAddStationIfRegisterDuplicatedStationName() {
        //given
        Station station = new Station("강남역");
        StationService.registerStation(station);
        Station duplicatedStation = new Station("강남역");

        //when //then
        assertThatThrownBy(() -> StationService.registerStation(duplicatedStation))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지하철 역의 목록을 조회하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "강남역,잠실역,사당역:3", "신림역,봉천역,서울대입구역,낙성대역:4"
            }, delimiter = ':'
    )
    void testFindAll(String input, int stationNumber) {
        //given
        String[] stationsNames = input.split(",");
        Arrays.stream(stationsNames)
                .map(Station::new)
                .forEach(StationRepository::addStation);

        //when
        List<Station> stations = StationService.findAll();

        //then
        List<Station> expectedStations = Arrays.stream(stationsNames)
                .map(Station::new)
                .collect(Collectors.toList());
        assertAll(
                () -> assertThat(stations)
                                .usingElementComparatorOnFields("name")
                                .containsAll(expectedStations),
                () -> assertThat(stations).hasSize(stationNumber)
        );
    }
}
