package subway.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.ErrorCode;
import subway.exception.LineException;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("숫자, 한글이 포함된 노선을 저장할 수 있다")
    void testSave() {
        //given
        String line = "1호선";
        String line2 = "2호선";

        //when
        Line saveLine = Line.of(line);
        Line saveLine2 = Line.of(line2);

        //then
        assertThat(saveLine.getName()).isEqualTo(line);
        assertThat(saveLine2.getName()).isEqualTo(line2);
    }

    @Test
    @DisplayName("2글자 미만인 구간의 이름이 들어올 시 에러가 발생한다.")
    void testLengthError() {
        //given
        String line = "선";
        String line2 = "샨";

        //then
        assertThatThrownBy(() -> Line.of(line))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_NAME_LENGTH_ERROR.getMessage());
        assertThatThrownBy(() -> Line.of(line2))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_NAME_LENGTH_ERROR.getMessage());
    }

    @Test
    @DisplayName("한글, 숫자가 아닌 이름이 들어올 시 에러가 발생한다.")
    void testSaveError() {
        //given
        String line = "Q선";
        String line2 = "기 선";

        //then
        assertThatThrownBy(() -> Line.of(line))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_INVALID_CHARACTER.getMessage());
        assertThatThrownBy(() -> Line.of(line2))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("마지막 글자가 선이 아닐 시 에러가 발생한다.")
    void testLastNameError() {
        //given
        String line = "1호션";
        String line2 = "2호신";

        //then
        assertThatThrownBy(() -> Line.of(line))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_INVALID_LAST_NAME.getMessage());
        assertThatThrownBy(() -> Line.of(line2))
                .isInstanceOf(LineException.class)
                .hasMessage(ErrorCode.LINE_INVALID_LAST_NAME.getMessage());
    }
}
