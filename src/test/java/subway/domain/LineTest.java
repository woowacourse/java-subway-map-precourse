package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("구간을 추가한다.")
    @Test
    public void addSection() throws Exception {
        Line line = new Line("새로운호선", new Station("시작역"), new Station("마지막역"));
        Station newStation = new Station("새로운역");
        line.addSection(newStation, 1);
        Station ascendingStation = line.getAscendingStation();
        assertThat(ascendingStation).isEqualTo(newStation);
    }

    @DisplayName("구간을 삭제한다.")
    @Test
    public void removeSection() throws Exception {
        Line line = new Line("새로운호선", new Station("시작역"), new Station("마지막역"));
        Station ascendingStation = line.getAscendingStation();
        line.removeSection(ascendingStation);
        assertThat(line.contains(ascendingStation)).isFalse();
    }

    @DisplayName("상행종점을 가져온다.")
    @Test
    public void getAscendingStation() throws Exception {
        Line line = new Line("새로운호선", new Station("시작역"), new Station("마지막역"));
        Assertions.assertThat(line.getAscendingStation()).isEqualTo(new Station("시작역"));
    }

    @DisplayName("하행종점을 가져온다.")
    @Test
    public void getDescendingStation() throws Exception {
        Line line = new Line("새로운호선", new Station("시작역"), new Station("마지막역"));
        Assertions.assertThat(line.getDescendingStation()).isEqualTo(new Station("마지막역"));
    }

    @DisplayName("역이 포함되어 있는지 확인한다.")
    @Test
    public void contains() throws Exception {
        Line line = new Line("새로운호선", new Station("시작역"), new Station("마지막역"));
        Assertions.assertThat(line.contains(new Station("시작역"))).isTrue();
        Assertions.assertThat(line.contains(new Station("없는역"))).isFalse();
    }
}
