package subway.domain.station.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class StationRepositoryTest {

    @AfterEach
    void tearDown() {
        StationRepository.deleteAll();
    }

    @DisplayName("station을 추가하는 기능을 테스트한다")
    @Test
    void testAddStation() {
        //given
        Station station = new Station("강남역");

        //when
        StationRepository.addStation(station);

        //thent
        List<Station> stations = StationRepository.stations();
        assertThat(stations)
                .extracting("name", String.class)
                .contains("강남역");
    }

    @DisplayName("지하철 역을 삭제하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "강남역,잠실역,사당역:잠실역:2", "신림역,봉천역,서울대입구역,낙성대역실:봉천역:3"
            }, delimiter = ':'
    )
    void testDeleteStation(String input, String removedStationName, int expectedStationsNumber) {
        //given
        String[] stationsNames = input.split(",");
        Arrays.stream(stationsNames)
                .map(Station::new)
                .forEach(StationRepository::addStation);

        //when
        StationRepository.deleteStation(removedStationName);

        //then
        List<Station> stations = StationRepository.stations();
        assertAll(
                () -> assertThat(stations).hasSize(expectedStationsNumber),
                () -> assertThat(stations).usingElementComparatorOnFields("name")
                        .doesNotContain(new Station(removedStationName))
        );
    }

    @DisplayName("지하철 역의 목록을 조회하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "강남역,잠실역,사당역:3", "신림역,봉천역,서울대입구역,낙성대역:4"
            }, delimiter = ':'
    )
    void testStations(String input, int stationNumber) {
        //given
        String[] stationsNames = input.split(",");
        Arrays.stream(stationsNames)
                .map(Station::new)
                .forEach(StationRepository::addStation);

        //when
        List<Station> stations = StationRepository.stations();

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
