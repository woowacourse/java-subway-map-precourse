package subway.station.domain;

import org.junit.jupiter.api.Test;
import subway.line.domain.Line;
import subway.line.domain.Route;

import static org.assertj.core.api.Assertions.assertThat;

class StationTest {
    @Test
    void 지하철역에_노선등록하는_기능_동작_확인() {
        //given
        Station topStation = new Station("잠실역");
        Station bottomStation = new Station("여의도역");
        Line line = new Line("1호선", new Route(topStation, bottomStation));

        Station station = new Station("수원역");
        station.addLine(line);

        //when
        assertThat(station.isRegistered()).isEqualTo(true);
    }
}