package subway.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LineTest {

    private final Sections sections = Sections.of(new Station("매봉역"), new Station("수서역"));
    private final Line line = new Line("1호선", sections);

    @DisplayName("Line 객체 생성 실패 : 이름이 2글자 미만, 공백, null인 경우")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"역", "  ", "\t  "})
    void Line_유효하지_않은_이름_예외가_발생한다(String name) {
        assertThatCode(() -> {
            new Line(name, sections);
        }).isInstanceOf(LineNameException.class)
                .hasMessage("지하철 노선 이름은 공백이 아닌 2글자 이상이어야 합니다.");
    }

    @DisplayName("Line 객체와 같은 이름 비교")
    @Test
    void matchesName_이름이_같으면_true를_반환한다() {
        boolean isEqual = line.matchesName("1호선");

        assertThat(isEqual).isTrue();
    }

    @DisplayName("Line 객체와 다른 이름 비교")
    @Test
    void matchesName_이름이_다르면_false를_반환한다() {
        boolean isEqual = line.matchesName("111호선");

        assertThat(isEqual).isFalse();
    }
}
