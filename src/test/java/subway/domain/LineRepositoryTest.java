package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import subway.controller.ManagementController;
import subway.controller.ManagementControllerTest;

class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    public void initLineRepository() {
        ManagementController managementController = ManagementControllerTest.initializeWithEmptyStations();

        lineRepository = managementController.lines();
    }

    @Test
    @DisplayName("중복되지 않은 노선 추가")
    public void addStation_NotDuplicateStation_NewLine() {

        // given
        Line newLine = new Line("1호선", "인천역", "소요산역");

        // when
        lineRepository = lineRepository.addLine(newLine);

        //then
        assertThat(lineRepository.lineNames()).containsExactly("2호선", "3호선", "신분당선", "1호선");
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        Line newLine = new Line("2호선", "교대역", "강남역", "역삼역");

        // when
        ThrowableAssert.ThrowingCallable callable = () -> lineRepository.addLine(newLine);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DUPLICATE_NAME_ERROR, "2호선");
    }
}