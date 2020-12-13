package subway.domain.command;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MainCommandTests {
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "Q"})
    public void 객체생성_성공(String userMessage) {
        assertThatCode(() -> MainCommand.getCommand(userMessage))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"5", "\t", "", "-1", " ", "A"})
    public void 객체생성_실패_예외발생_테스트(String userMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> MainCommand.getCommand(userMessage));
    }
}
