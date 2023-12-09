package subway.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StationTest {

    @DisplayName("역 이름이 2글자 이상이고 '역'으로 끝나면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"가나역", "가나다역"})
    public void create(String input) throws Exception {
        Assertions.assertThatCode(() -> new Station(input))
                .doesNotThrowAnyException();
    }

    @DisplayName("역 이름이 2글자 미만이거나, 한글이 아니거나, 역으로 끝나지 않으면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"가역", "asd역", "123", "역", "", " ", "가나다12역"})
    public void createFail(String input) throws Exception {
        Assertions.assertThatCode(() -> new Station(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
