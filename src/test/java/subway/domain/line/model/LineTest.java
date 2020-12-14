package subway.domain.line.model;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.station.model.Station;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("Line 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest()
    @ValueSource(strings = {
            "2호선", "3호선", "4호선"
    })
    void testInitLine(String name) {
        //given
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());

        //when
        Line line = new Line(name, stations);

        //then
        assertThat(line).extracting("name").isEqualTo(name);
    }

    @DisplayName("최소 노선이름 길이보다 노선 이름이 짧으면 예외를 던지는 기능을 테스트한다 ")
    @ParameterizedTest
    @ValueSource(strings = {
            "1", "2", "3"
    })
    void testInitLineIfLineNameIsShorterThanMinLineName(String name) {
        //given
        String stationName = "잠실역";
        List<Station> stations = Arrays.asList(new Station(stationName));

        //when //then
        assertThatThrownBy(() -> new Line(name, stations))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선의 구간이 초기 구간제한 갯수보다 작으면 예외를 던지는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(strings = {
            "잠실역"
    })
    void testInitLineIfStationsNumberLessThanInitStationsNumber(String stationNames) {
        //given
        String lineName = "2호선";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());

        //when //then
        assertThatThrownBy(() -> new Line(lineName, stations))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선에 구간을 추가하는 기능을 테스트한다")
    @Test
    void testAddStation() {
        //given
        String name = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(name, stations);

        Station newStation = new Station("사당역");
        int newStationLocation = 1;

        //when
        line.addStation(newStationLocation, newStation);

        //then
        assertThat(line.getStations()).contains(newStation, Index.atIndex(newStationLocation));
    }

    @DisplayName("적절하지 않은 위치에 구간을 추가할 때, 예외를 던지는 기능을 테스트한다")
    @ParameterizedTest
    @ValueSource(ints = {
            0, 2, 3
    })
    void testAddStationIfNotSatisfiedIndexNumber(int newStationLocation) {
        //given
        String name = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(name, stations);

        Station newStation = new Station("사당역");

        //when //then
        assertThatThrownBy(() -> line.addStation(newStationLocation, newStation))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("노선에 등록된 역을 제거하는 기능을 테스트한다")
    @Test
    void testRemoveStation() {
        //given
        String name = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(name, stations);

        Station newStation = new Station("사당역");
        int newStationLocation = 1;
        line.addStation(newStationLocation, newStation);

        //when
        line.removeStation("사당역");

        //then
        assertAll(
                () -> assertThat(line.getStations()).hasSize(2),
                () -> assertThat(line.getStations())
                        .usingElementComparatorOnFields("name")
                .containsExactlyInAnyOrder(new Station("강남역"), new Station("잠실역"))
        );
    }

    @DisplayName("종점을 제거할 경우 다음 역이 종점이 되는 기능을 테스트한다")
    @Test
    void testRemoveStationIfRemoveStationIsBoundTerminus() {
        //given
        String name = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(name, stations);

        Station newStation = new Station("사당역");
        int newStationLocation = 1;
        line.addStation(newStationLocation, newStation);

        //when
        line.removeStation("강남역");

        //then
        assertAll(
                () -> assertThat(line.getStations()).hasSize(2),
                () -> assertThat(line.getStations())
                        .usingElementComparatorOnFields("name")
                .containsExactlyInAnyOrder(new Station("잠실역"), new Station("사당역"))
        );
    }

    @DisplayName("노선에 포함된 역이 두개 이하일 때는 예외를 발생시키는 기능을 테스트한다")
    @Test
    void testRemoveStationIfStationsSize() {
        //given
        String name = "2호선";
        String stationNames = "강남역,잠실역";
        List<Station> stations = Arrays.stream(stationNames.split(","))
                .map(Station::new)
                .collect(Collectors.toList());
        Line line = new Line(name, stations);

        //when //then
        assertThatThrownBy(() -> line.removeStation("강남역"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
