package subway.domain;

import org.junit.jupiter.api.Test;
import subway.Application;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    @Test
    public void 노선_초기화(){
        Application.init();

        List<Line> lines = LineRepository.lines();
        Station station = lines.get(0).getStations().get(0);

        assertThat("2호선").isEqualTo(lines.get(0).getName());
        assertThat("교대역").isEqualTo(station.getName());

    }

    @Test
    public void 노선_등록_테스트(){
        String test = "test";
        String lengthError = "a";
        Line line = new Line(test);

        assertThat(false).isEqualTo(line.addStation(lengthError));
    }

}