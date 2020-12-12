package subway.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionTypeTest {

    private static Stream<Arguments> getFunctionTypeAndFunctionNumberSource() {
        return Stream.of(Arguments.of(FunctionType.REGISTER, "1"),
                Arguments.of(FunctionType.DELETE, "2"),
                Arguments.of(FunctionType.READ, "3"),
                Arguments.of(FunctionType.BACK, "B"));
    }

    @DisplayName("객체의 functionNumber와 매개변수 functionNumber 비교")
    @ParameterizedTest
    @MethodSource("getFunctionTypeAndFunctionNumberSource")
    void matches_같으면_true를_반환한다(FunctionType functionType, String functionNumber) {
        boolean isMatch = functionType.matches(functionNumber);

        assertThat(isMatch).isTrue();
    }
}
