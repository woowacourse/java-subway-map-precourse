package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository();
    }

    @Test
    @DisplayName("중복되지 않은 노선 추가 시 예외 미발생")
    public void addStation_NotDuplicateStation_NoExceptionThrown() {

        // given
        lineRepository.addLine("신분당선");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addLine("2호선");

        //then
        assertThatCode(callable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        lineRepository.addLine("신분당선");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addLine("신분당선");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DUPLICATE_NAME_ERROR, "신분당선");
    }

    @Test
    @DisplayName("존재하는 노선 삭제 시 예외 미발생")
    public void deleteStation_ExistLine_ExceptionThrown() {

        // given
        lineRepository.addLine("신분당선");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.deleteLineByName("신분당선");

        //then
        assertThatCode(callable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("존재하지 않는 노선 삭제 시 예외 발생")
    public void deleteStation_DoesNotExistLine_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.deleteLineByName("신분당선");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DOES_NOT_EXIST_ERROR, "신분당선");
    }
}