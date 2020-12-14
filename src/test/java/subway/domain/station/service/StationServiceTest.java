package subway.domain.station.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
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
        LineRepository.deleteAll();
    }

    @DisplayName("station을 추가하는 기능을 테스트한다")
    @Test
    void testSave() {
        //given
        Station station = new Station("강남역");

        //when
        StationService.save(station);

        //thent
        List<Station> stations = StationRepository.stations();
        assertThat(stations)
                .extracting("name", String.class)
                .contains("강남역");
    }

    @DisplayName("중복되는 이름의 station을 추가하면 예외를 발생시킨다.")
    @Test
    void testSaveIfRegisterDuplicatedStationName() {
        //given
        Station station = new Station("강남역");
        StationService.save(station);
        Station duplicatedStation = new Station("강남역");

        //when //then
        assertThatThrownBy(() -> StationService.save(duplicatedStation))
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

    @DisplayName("지하철 역을 삭제하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "강남역,잠실역,사당역:잠실역:2", "신림역,봉천역,서울대입구역,낙성대역실:봉천역:3"
            }, delimiter = ':'
    )
    void testRemove(String input, String removedStationName, int expectedStationsNumber) {
        //given
        String[] stationsNames = input.split(",");
        Arrays.stream(stationsNames)
                .map(Station::new)
                .forEach(StationRepository::addStation);

        //when
        StationService.remove(removedStationName);

        //then
        List<Station> stations = StationService.findAll();
        assertAll(
                () -> assertThat(stations).hasSize(expectedStationsNumber),
                () -> assertThat(stations).usingElementComparatorOnFields("name")
                        .doesNotContain(new Station(removedStationName))
        );
    }

    @DisplayName("노선에 등록된 역을 삭제하면 예외를 발생시키는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "강남역,잠실역,사당역:잠실역", "신림역,봉천역,서울대입구역,낙성대역실:봉천역"
            }, delimiter = ':'
    )
    void testRemoveIfStationIsContainLine(String input, String removedStationName) {
        //given
        String[] stationsNames = input.split(",");
        Arrays.stream(stationsNames)
                .map(Station::new)
                .forEach(StationRepository::addStation);

        List<Station> stations = Arrays.stream(stationsNames)
                .map(Station::new)
                .collect(Collectors.toList());

        LineRepository.addLine(new Line("2호선", stations));

        //when //then
        assertThatThrownBy(() -> StationService.remove(removedStationName))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
