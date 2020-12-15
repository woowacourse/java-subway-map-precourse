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
import subway.exception.function.NotFoundElementException;
import subway.exception.function.TooLessStationException;

public class RemoveStationTest {

    private LineRepository lineRepository;

    @BeforeEach
    public void initLineRepository() {
        ManagementController managementController =
                ManagementControllerTest.initializeWithEmptyStations();

        lineRepository = managementController.lines();
    }

    @Test
    @DisplayName("존재하는 노선 삭제")
    public void removeLine_ExistLine_EmptyLines() {

        // when
        lineRepository = lineRepository.removeLine("2호선");

        //then
        assertThat(lineRepository.lineNames()).containsExactly("3호선", "신분당선");
    }

    @Test
    @DisplayName("존재하지 않는 노선 삭제 시 예외 발생")
    public void removeLine_DoesNotExistLine_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.removeLine("1호선");

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(NotFoundElementException.class)
                .hasMessage(SubwayRuntimeException.ERROR + NotFoundElementException.NOT_FOUND_ERROR,
                        "1호선");
    }

    @Test
    @DisplayName("구간 삭제")
    public void removeSection_oldSection_SectionRemoved() {

        // when
        lineRepository = lineRepository.removeSection("2호선", "역삼역");

        //then
        assertThat(lineRepository.getStationNamesByLineName("2호선")).containsExactly("교대역", "강남역");
    }

    @Test
    @DisplayName("노선의 역 개수가 최소 역 개수 이하일 경우 역 제거 시 예외 발생")
    public void removeSection_LessThanMinimumStationSize_ExceptionThrown() {

        // given
        lineRepository = lineRepository.removeSection("2호선", "역삼역");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.removeSection("2호선", "교대역");

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(TooLessStationException.class)
                .hasMessage(SubwayRuntimeException.ERROR +
                        TooLessStationException.TOO_LESS_STATIONS_ERROR);
    }

    @Test
    @DisplayName("상행 종점을 제거할 경우 그 다음 역이 종점")
    public void removeSection_StartStation_StartsWithNextStation() {

        // when
        lineRepository = lineRepository.removeSection("2호선", "교대역");

        //then
        assertThat(lineRepository.getStationNamesByLineName("2호선")).containsExactly("강남역", "역삼역");
    }

    @Test
    @DisplayName("하행 종점을 제거할 경우 그 다음 역이 종점")
    public void removeSection_FinalStation_EndWithNextStation() {

        // when
        lineRepository = lineRepository.removeSection("2호선", "역삼역");

        //then
        assertThat(lineRepository.getStationNamesByLineName("2호선")).containsExactly("교대역", "강남역");
    }
}
