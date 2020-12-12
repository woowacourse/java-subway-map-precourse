package subway.line;

import org.junit.jupiter.api.Test;
import subway.station.exception.NotSupportedFunctionException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LineFunctionMapperTest {
    @Test
    void 존재하지않는_기능_입력시_예외_발생() {
        //given
        String notSupportedCommand = "5";

        //when & then
        assertThatExceptionOfType(NotSupportedFunctionException.class)
                .isThrownBy(() -> LineFunctionMapper.matchFunction(notSupportedCommand));
    }
}