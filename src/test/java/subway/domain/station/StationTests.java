package subway.domain.station;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StationTests {
    @ParameterizedTest
    @ValueSource(strings = {"잠실", "종로3가", "London Bridge", "station"})
    public void 객체생성_성공(String carName) {
        assertThatCode(() -> new Station(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "\t", "a", "abc!@", "London  Bridge"})
    public void 객체생성_실패_예외발생_테스트(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Station(name));
    }
}
