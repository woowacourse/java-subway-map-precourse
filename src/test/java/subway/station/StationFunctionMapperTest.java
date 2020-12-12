package subway.station;

import org.junit.jupiter.api.Test;
import subway.station.exception.NotSupportedFunctionException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StationFunctionMapperTest {
    @Test
    void 지원하지않는_기능_입력시_예외_발생해야함() {
        //given
        String notSupportedCommand = "5";

        //when & then
        assertThatExceptionOfType(NotSupportedFunctionException.class)
                .isThrownBy(() -> StationFunctionMapper.matchFunction(notSupportedCommand));
    }
}