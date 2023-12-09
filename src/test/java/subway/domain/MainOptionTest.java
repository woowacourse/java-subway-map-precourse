package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MainOptionTest {

    @DisplayName("존재하는 메인 메뉴를 선택하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "Q"})
    public void of(String input) throws Exception {
        Assertions.assertThatCode(() -> MainOption.of(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("존재하지 않는 메인 메뉴를 선택하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "5", "asd", "123", "가나", "ㄱ"})
    public void ofFail(String input) throws Exception {
        Assertions.assertThatCode(() -> MainOption.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
