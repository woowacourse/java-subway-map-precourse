package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InsertStationTest {

    private final Line line;

    private LineRepository lineRepository;

    public InsertStationTest() {
        line = new Line("1호선", "강남역", "잠실역");
    }

    @BeforeEach
    public void initLineRepository() {
        lineRepository = new LineRepository().addLine(line);
    }

    @Test
    @DisplayName("존재하지 않는 노선에 역 삽입 시 예외 발생")
    public void insertStation_DoesNotExistLine_ExceptionThrown() {

        // given
        int index = 1;
        String stationName = "잠실역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.insertStation("11호선", index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(LineRepository.DOES_NOT_EXIST_ERROR, "11호선");
    }

    @Test
    @DisplayName("구간에 중복되지 않은 역 삽입")
    public void insertStation_NewStation_LineRepositoryInsertedStation() {

        // given
        int index = 1;
        String stationName = "봉천역";

        // when
        LineRepository newLineRepository =
                lineRepository.insertStation(line.getName(), index, stationName);

        //then
        assertThat(newLineRepository.lines().size()).isEqualTo(1);
        assertThat(newLineRepository.contains(stationName)).isTrue();
    }

    @Test
    @DisplayName("구간에 중복되지 않은 역 삽입 시 예외 발생")
    public void insertStation_DuplicateStation_ExceptionThrown() {

        // given
        int index = 1;
        String stationName = "잠실역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.insertStation(line.getName(), index, stationName);

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
                () -> lineRepository.insertStation(line.getName(), index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.OUT_OF_BOUNDS_ERROR,
                        StationRepository.MINIMUM_INDEX, 2);
    }

    @Test
    @DisplayName("구간 순서가 최대값보다 클 경우 예외 발생")
    public void insertStation_HigherThanStationSize_ExceptionThrown() {

        // given
        int index = 2;
        String stationName = "잠실역";

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> lineRepository.insertStation(line.getName(), index, stationName);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.OUT_OF_BOUNDS_ERROR,
                        StationRepository.MINIMUM_INDEX, 2);
    }
}
