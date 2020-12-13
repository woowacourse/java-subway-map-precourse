package subway.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class StationTest {

    private final Station station = new Station("이수역");

    @DisplayName("Station 객체 생성 실패 : 이름이 2글자 미만, 공백, null인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"역", "  ", "\t  "})
    void Station_유효하지_않은_이름_예외가_발생한다(String name) {
        assertThatCode(() -> {
            new Station(name);
        }).isInstanceOf(StationNameException.class)
                .hasMessage("이미 등록된 역 이름입니다.");
    }

    @DisplayName("Station 객체와 이름이 같은 경우")
    @Test
    void matchesName_이름이_같으면_true를_반환한다() {
        boolean isEqual = station.matchesName("이수역");

        assertThat(isEqual).isTrue();
    }

    @DisplayName("Station 객체와 이름이 다른 경우")
    @Test
    void matchesName_이름이_다르면_false를_반환한다() {
        boolean isEqual = station.matchesName("다른역");

        assertThat(isEqual).isFalse();
    }
}
