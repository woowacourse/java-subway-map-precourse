package subway.section;

import org.junit.jupiter.api.Test;
import subway.common.exception.NotSupportedFunctionException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class SectionFunctionMapperTest {
    @Test
    void 존재하지않는_기능_입력시_예외_발생() {
        //given
        String notSupportedCommand = "3";

        //when & then
        assertThatExceptionOfType(NotSupportedFunctionException.class)
                .isThrownBy(() -> SectionFunctionMapper.matchFunction(notSupportedCommand));
    }
}