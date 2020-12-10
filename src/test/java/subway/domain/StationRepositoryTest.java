package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
        StationRepository repositoryAddedKangnam = stationRepository.addStation("강남역");

        // when
        StationRepository repositoryAddedBongcheon = repositoryAddedKangnam.addStation("봉천역");

        //then
        assertThat(repositoryAddedBongcheon.stations())
                .containsExactly(new Station("강남역"), new Station("봉천역"));
    }

    @Test
    @DisplayName("중복된 역 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        StationRepository repositoryAddedKangnam = stationRepository.addStation("강남역");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> repositoryAddedKangnam.addStation("강남역");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DUPLICATE_NAME_ERROR, "강남역");
    }

    @Test
    @DisplayName("존재하는 역 삭제 시 예외 미발생")
    public void deleteStation_ExistStation_ExceptionThrown() {

        // given
        StationRepository repositoryAddedKangnam = stationRepository.addStation("강남역");

        LineRepository lineRepository = new LineRepository();

        // when
        StationRepository repositoryRemovedKangnam =
                repositoryAddedKangnam.removeStation("강남역", lineRepository);

        //then
        assertThat(repositoryRemovedKangnam.stations()).isEmpty();
    }

    @Test
    @DisplayName("존재하지 않는 역 삭제 시 예외 발생")
    public void deleteStation_DoesNotExistStation_ExceptionThrown() {

        // given
        LineRepository lineRepository = new LineRepository();

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.removeStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DOES_NOT_EXIST_ERROR, "강남역");
    }

    @Test
    @DisplayName("노선에 등록되어 있는 역 삭제 시 예외 발생")
    public void deleteStation_SavedStationAtLine_ExceptionThrown() {

        // given
        StationRepository repositoryAddedKangnam = stationRepository.addStation("강남역");

        LineRepository lineRepository = new LineRepository().addLine(new Line("1호선", "강남역", "잠실역"));

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> repositoryAddedKangnam.removeStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.SAVED_AT_LINE_ERROR, "강남역");
    }
}