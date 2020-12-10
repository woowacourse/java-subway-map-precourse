package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StationRepositoryTest {

    private StationRepository stationRepository;

    @BeforeEach
    public void initStationRepository() {
        stationRepository = new StationRepository();
    }

    @Test
    @DisplayName("중복되지 않은 역 추가 시 예외 미발생")
    public void addStation_NotDuplicateStation_NoExceptionThrown() {

        // given
        stationRepository.addStation("강남역");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.addStation("봉천역");

        //then
        assertThatCode(callable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 역 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        stationRepository.addStation("강남역");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.addStation("강남역");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DUPLICATE_NAME_ERROR, "강남역");
    }

    @Test
    @DisplayName("존재하는 역 삭제 시 예외 미발생")
    public void deleteStation_ExistStation_ExceptionThrown() {

        // given
        stationRepository.addStation("강남역");

        LineRepository lineRepository = new LineRepository();

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.deleteStation("강남역", lineRepository);

        //then
        assertThatCode(callable).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("존재하지 않는 역 삭제 시 예외 발생")
    public void deleteStation_DoesNotExistStation_ExceptionThrown() {

        // given
        LineRepository lineRepository = new LineRepository();

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.deleteStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DOES_NOT_EXIST_ERROR, "강남역");
    }

    @Test
    @DisplayName("노선에 등록되어 있는 역 삭제 시 예외 발생")
    public void deleteStation_SavedStationAtLine_ExceptionThrown() {

        // given
        stationRepository.addStation("강남역");

        LineRepository lineRepository = new LineRepository();
        lineRepository.addLine(new Line("1호선", "강남역", "잠실역"));

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.deleteStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.SAVED_AT_LINE_ERROR, "강남역");
    }
}