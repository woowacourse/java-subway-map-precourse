package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationFactoryTest {
    @DisplayName("역을 생성한다")
    @Test
    void 역을_생성한다() {
        String testName = "사당역";
        assertThat(StationFactory.makeStation(testName)).isEqualTo(new Station(testName));
    }

    @DisplayName("예외1. 지하철 역 이름이 2글자 미만이면 예외를 발생시킨다.")
    @Test
    void 역이름_2글자_예외처리() {
        assertThatThrownBy(() -> StationFactory.makeStation("일"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 역의 이름은 2글자 이상이어야 합니다.");
    }
}