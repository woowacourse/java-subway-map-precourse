package subway.domain.line.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("Line 객체를 생성하는 기능을 테스트한다")
    @ParameterizedTest()
    @ValueSource(strings = {
            "2호선", "3호선", "4호선"
    })
    void testInitLine(String name) {
        //when
        Line line = new Line(name);

        //then
        assertThat(line).extracting("name").isEqualTo(name);
    }

    @DisplayName("최소 호선이름 길이보다 호선이름이 짧을 경우 예외를 발생하는 기능을 테스트한다 ")
    @ParameterizedTest
    @ValueSource(strings = {
            "1", "2", "3"
    })
    void testInitLineIfLineNameIsShorterThanMinLineName(String name) {
        //when //then
        assertThatThrownBy(() -> new Line(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
