package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineFactoryTest {

    @DisplayName("라인을 생성한다")
    @Test
    void makeLineTest() {
        String lineName = "2호선";
        Station startStation = StationFactory.makeStation("구로디지털단지역");
        Station lastStation = StationFactory.makeStation("홍대입구역");
        Line lineFromFactory = LineFactory.makeLine(lineName, startStation, lastStation);

        assertThat(lineFromFactory).isEqualTo(new Line("2호선", startStation, lastStation));
    }

    @DisplayName("예외 : 노선 이름이 2글자 미만이면 예외를 발생시킨다.")
    @Test
    void 노선이름_2글자_예외처리() {
        String shortLineName = "2";
        Station startStation = StationFactory.makeStation("구로디지털단지역");
        Station lastStation = StationFactory.makeStation("홍대입구역");

        assertThatThrownBy(() -> LineFactory.makeLine(shortLineName,startStation,lastStation))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 노선의 이름은 2글자 이상이어야 합니다.");
    }
}