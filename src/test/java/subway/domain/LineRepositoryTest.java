package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import subway.controller.ManagementController;
import subway.controller.ManagementControllerTest;
import subway.exception.SubwayRuntimeException;
import subway.exception.function.AlreadyExistsException;

class LineRepositoryTest {

    private LineRepository lineRepository;

    @BeforeEach
    public void initLineRepository() {
        ManagementController managementController =
                ManagementControllerTest.initializeWithEmptyStations();

        lineRepository = managementController.lines();
    }

    @Test
    @DisplayName("중복되지 않은 노선 추가")
    public void addLine_NotDuplicateLine_NewLine() {

        // given
        Line newLine = new Line("1호선", "인천역", "소요산역");

        // when
        lineRepository.addLine(newLine);

        //then
        assertThat(lineRepository.lineNames()).containsExactly("2호선", "3호선", "신분당선", "1호선");
    }

    @Test
    @DisplayName("중복된 노선 추가 시 예외 발생")
    public void addLine_DuplicateLine_ExceptionThrown() {

        // given
        Line newLine = new Line("2호선", "교대역", "강남역", "역삼역");

        // when
        ThrowableAssert.ThrowingCallable callable = () -> lineRepository.addLine(newLine);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(AlreadyExistsException.class)
                .hasMessage(SubwayRuntimeException.ERROR +
                        AlreadyExistsException.ALREADY_EXISTS_ERROR, "2호선", "노선");
    }
}