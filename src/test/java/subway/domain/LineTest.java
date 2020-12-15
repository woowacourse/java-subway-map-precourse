package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.SubwayException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    static final String SECOND_LINE_NAME = "2호선";
    static final String SADANG_STATION = "사당역";
    Line secondLine;
    Station startStation;
    Station endStation;

    @BeforeEach
    void setUpEach() {
        startStation = StationFactory.makeStation(SADANG_STATION);
        endStation = StationFactory.makeStation("신대방역");
        secondLine = LineFactory.makeLine(SECOND_LINE_NAME, startStation, endStation);
    }

    @DisplayName("노선에 구간을 추가한다")
    @Test
    void addStationAtLineTest(){
        String testName = "산본역";
        secondLine.addSection(1, StationFactory.makeStation(testName));

        assertThat(secondLine.sectionsNames()).contains(testName);
    }


    @DisplayName("노선에 등록된 구간을 삭제한다")
    @Test
    void deleteStationAtLineTest() {
        secondLine.addSection(0, StationFactory.makeStation("산본역"));
        int beforeSize = secondLine.size();
        secondLine.deleteStation(SADANG_STATION);
        assertThat(secondLine.size()).isEqualTo(beforeSize - 1);
    }


    @DisplayName("예외 : 노선에 등록된 역의 수가 2이하이면 예외")
    @Test
    void 노선에_등록된_역의_수가_적다() {
        assertThatThrownBy(() -> secondLine.deleteStation(SADANG_STATION))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 노선에 등록된 역의 개수는 2개 보다 많아야 합니다.");
    }
}
