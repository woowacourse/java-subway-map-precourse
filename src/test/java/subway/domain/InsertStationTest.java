package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import subway.controller.ManagementController;
import subway.controller.ManagementControllerTest;
import subway.exception.NotFoundElementException;
import subway.exception.SubwayRuntimeException;

public class InsertStationTest {

    private LineRepository lineRepository;

    private Line line;

    @BeforeEach
    public void initLineRepository() {
        ManagementController managementController =
                ManagementControllerTest.initializeWithEmptyStations();

        lineRepository = managementController.lines();

        line = lineRepository.lines().get(0);
    }

    @Test
    @DisplayName("존재하지 않는 노선에 역 삽입 시 예외 발생")
    public void insertStation_DoesNotExistLine_ExceptionThrown() {

        // given
        int index = 1;
        String stationName = "인천역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addRange("1호선", index, stationName);

        //then
        assertThatThrownBy(callable).isExactlyInstanceOf(NotFoundElementException.class)
                .hasMessage(SubwayRuntimeException.ERROR + NotFoundElementException.NOT_FOUND_ERROR,
                        "1호선");
    }

    @Test
    @DisplayName("구간에 중복되지 않은 역 삽입")
    public void insertStation_NewStation_LineRepositoryInsertedStation() {

        // given
        int index = 1;
        String stationName = "봉천역";

        // when
        lineRepository = lineRepository.addRange(line.getName(), index, stationName);

        //then
        assertThat(lineRepository.getStationNamesByLineName("2호선"))
                .containsExactly("교대역", "봉천역", "강남역", "역삼역");
    }

    @Test
    @DisplayName("구간에 중복된 역 삽입 시 예외 발생")
    public void insertStation_DuplicateStation_ExceptionThrown() {

        // given
        int index = 1;
        String stationName = "교대역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addRange(line.getName(), index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DUPLICATE_NAME_ERROR, stationName);
    }

    @Test
    @DisplayName("구간 순서가 최소값보다 작을 경우 예외 발생")
    public void insertStation_LowerThanMinimumIndex_ExceptionThrown() {

        // given
        int index = 0;
        String stationName = "봉천역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addRange(line.getName(), index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.OUT_OF_BOUNDS_ERROR,
                        StationRepository.MINIMUM_INDEX, 3);
    }

    @Test
    @DisplayName("구간 순서가 최대값보다 클 경우 예외 발생")
    public void insertStation_HigherThanStationSize_ExceptionThrown() {

        // given
        int index = 3;
        String stationName = "봉천역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.addRange(line.getName(), index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.OUT_OF_BOUNDS_ERROR,
                        StationRepository.MINIMUM_INDEX, 3);
    }
}
