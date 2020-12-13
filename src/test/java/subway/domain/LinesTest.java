package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {
    static final String SECOND_LINE_NAME = "2호선";
    public static final String THIRD_LINE_NAME = "3호선";
    public static final String FORTH_LINE_NAME = "4호선";
    Lines lines;
    Line secondLine;
    Station startStation;
    Station endStation;

    @BeforeEach
    void setUpEach() {
        lines = new Lines();
        startStation = StationFactory.makeStation("사당역");
        endStation = StationFactory.makeStation("신대방역");
        secondLine = LineFactory.makeLine(SECOND_LINE_NAME, startStation, endStation);
        lines.addLine(secondLine);
    }

    @DisplayName("라인을 추가한다")
    @Test
    void addLineTest() {
        int beforeSize = lines.size();

        String lineName = THIRD_LINE_NAME;
        Station startStation = StationFactory.makeStation("양재역");
        Station lastStation = StationFactory.makeStation("고속터미널역");
        Line line = LineFactory.makeLine(lineName, startStation, lastStation);
        lines.addLine(line);

        assertThat(lines.size()).isEqualTo(beforeSize + 1);
    }

    @DisplayName("예외 : 같은 이름의 노선이 있으면 예외를 발생시킨다")
    @Test
    void shortLineNameTest() {
        Station startStation = StationFactory.makeStation("사당역");
        Station lastStation = StationFactory.makeStation("신대방역");

        Line sameNameline = LineFactory.makeLine(SECOND_LINE_NAME, startStation, lastStation);

        assertThatThrownBy(() -> lines.addLine(sameNameline))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("[ERROR] 이미 등록된 노선명입니다.");
    }

    @DisplayName("노선을 삭제한다")
    @Test
    void deleteLineTest() {
        int beforeSize = lines.size();
        lines.deleteLine(SECOND_LINE_NAME);
        assertThat(lines.size()).isEqualTo(beforeSize - 1);
    }

    @DisplayName("노선을 찾는다")
    @Test
    void findLineTest() {
        assertThat(lines.findLine(SECOND_LINE_NAME)).isEqualTo(secondLine);
    }

    @DisplayName("예외 : 노선이름이 없으면 에러가 발생한다")
    @Test
    void 노선이름이_없으면_예외() {
        assertThatThrownBy(() -> lines.findLine("3호선"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("[ERROR] 해당 노선이 없습니다.");
    }

    @DisplayName("노선 목록을 조회한다")
    @Test
    void lineNamesTest() {
        lines.addLine(LineFactory.makeLine(THIRD_LINE_NAME, startStation, endStation));
        lines.addLine(LineFactory.makeLine(FORTH_LINE_NAME, startStation, endStation));

        List<String> expectedNames = Arrays.asList(SECOND_LINE_NAME, THIRD_LINE_NAME, FORTH_LINE_NAME);
        assertThat(lines.lineNames()).isEqualTo(expectedNames);
    }
}