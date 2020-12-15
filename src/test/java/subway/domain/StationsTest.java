package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.SubwayException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationsTest {
    static Stations stations;

    @BeforeEach
    void setUpEach() {
        stations = new Stations();
    }

    @DisplayName("역을 등록한다")
    @Test
    void 역을_등록한다() {
        String testName = "사당역";

        Station testStation = StationFactory.makeStation(testName);
        stations.addStation(testStation);

        assertThat(stations.size()).isEqualTo(1);
        assertThat(stations.findStation(testName)).isEqualTo(testStation);
    }

    @DisplayName("예외 : 이미 등록된 역 이름을 등록하면 예외를 발생시킨다")
    @Test
    void 이미_등록된_역이름() {
        String testName = "선릉역";
        stations.addStation(StationFactory.makeStation(testName));

        assertThatThrownBy(() -> stations.addStation(StationFactory.makeStation(testName)))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 이미 등록된 역명입니다.");
    }

    @DisplayName("이름으로 역을 찾는다")
    @Test
    void 이름으로_역을_찾는다() {
        String testName = "신대방역";
        Station testStation = StationFactory.makeStation(testName);
        stations.addStation(testStation);

        assertThat(stations.findStation(testName)).isEqualTo(testStation);
    }

    @DisplayName("예외 : 찾는 이름의 역이 없으면 에러를 발생시킨다")
    @Test
    void 해당_이름이_없다() {
        String testName = "신대방역";

        assertThatThrownBy(() -> stations.findStation(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 해당 역이 없습니다.");
    }

    @DisplayName("역을 삭제한다")
    @Test
    void 역을_삭제한다() {
        String testName = "노들역";
        stations.addStation(StationFactory.makeStation(testName));

        stations.deleteStation(testName);
        assertThat(stations.size()).isEqualTo(0);
    }

    @DisplayName("예외 : 삭제하려는 역이 없으면 에러를 발생시킨다")
    @Test
    void 삭제하려는_역이_없다() {
        String testName = "상도역";
        stations.addStation(StationFactory.makeStation(testName));

        String errorName = "장승역";
        assertThatThrownBy(() -> stations.deleteStation(errorName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 해당 역이 없습니다.");
    }

    @DisplayName("예외 : 삭제하려는 역이 노선에 등록되어 있으면 에러를 발생시킨다")
    @Test
    void 노선에_등록된_역() {
        Station station1 = StationFactory.makeStation("상도역");
        Station station2 = StationFactory.makeStation("장승역");
        Station station3 = StationFactory.makeStation("잠실새내역");

        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        LineRepository.addLine(LineFactory.makeLine("2호선", station1, station2));

        assertThatThrownBy(() -> StationRepository.deleteStation(station1.getName()))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
    }

    @DisplayName("지하철역 목록을 조회한다")
    @Test
    void 역_목록을_조회한다() {
        String testName1 = "신도림역";
        String testName2 = "9와4/3역";
        String testName3 = "울릉도역";

        stations.addStation(StationFactory.makeStation(testName1));
        stations.addStation(StationFactory.makeStation(testName2));
        stations.addStation(StationFactory.makeStation(testName3));

        // 9와4/3역, 신도림역, 울릉도역 순서
        List<String> expectedNames = Arrays.asList(testName2, testName1, testName3);

        assertThat(stations.stationNames()).isEqualTo(expectedNames);
    }
}