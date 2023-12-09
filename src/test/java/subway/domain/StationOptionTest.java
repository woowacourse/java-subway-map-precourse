package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.controller.station.StationOption;

public class StationOptionTest {

    @DisplayName("존재하는 역 관리 기능을 입력하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "B"})
    public void of(String input) throws Exception {
        Assertions.assertThatCode(() -> StationOption.of(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 역 관리 기능을 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "4", "a", "가"})
    public void ofFail(String input) throws Exception {
        Assertions.assertThatCode(() -> StationOption.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
