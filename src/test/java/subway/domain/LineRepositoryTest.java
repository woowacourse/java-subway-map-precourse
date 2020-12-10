package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineRepositoryTest {

    private final Line line;

    private LineRepository lineRepository;

    public LineRepositoryTest() {
        line = new Line("1호선", "강남역", "잠실역");
    }

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository().addLine(line);
    }

    @Test
    @DisplayName("중복되지 않은 노선 추가")
    public void addStation_NotDuplicateStation_NewLine() {

        // given
        Line newLine = new Line("2호선", "강남역", "봉천역");

        // when
        LineRepository newLineRepository = lineRepository.addLine(newLine);

        //then
        assertThat(newLineRepository.lines().size()).isEqualTo(2);
        assertThat(newLineRepository.lines().get(1).getName()).isEqualTo("2호선");
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addLine(line);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DUPLICATE_NAME_ERROR, "1호선");
    }
}