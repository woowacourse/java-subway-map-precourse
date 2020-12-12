package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationTest {

    @DisplayName("Station 팩터리 메서드 validate 테스트")

    @Test
    public void testFactoryMethodValidate() {
        IllegalArgumentException throwNameContainWhitespace = assertThrows(
            IllegalArgumentException.class, () -> testNameContainWhitespace());
        assertThat(throwNameContainWhitespace.getMessage()).isEqualTo("지하철 역 이름에 공백이 포함될 수 없습니다.");

        IllegalArgumentException throwNameEndWithRule = assertThrows(
            IllegalArgumentException.class, () -> testNameEndWithRule());
        assertThat(throwNameEndWithRule.getMessage()).isEqualTo("지하철 역 이름은 \"역\"으로 끝나야 합니다.");

        IllegalArgumentException throwNameLength = assertThrows(
            IllegalArgumentException.class, () -> testNameLength());
        assertThat(throwNameLength.getMessage()).isEqualTo("지하철 역 이름은 2글자 이상 + \"역\"으로 이루어져야 합니다.");
    }

    public void testNameContainWhitespace() {
        Station.newStation("길동 역");
    }

    private void testNameEndWithRule() {
        Station.newStation("길동");
    }

    public void testNameLength() {
        Station.newStation("길역");
    }
}
