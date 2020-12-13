package subway.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import subway.controller.ManageController;
import subway.controller.ManageControllerTest;

class StationRepositoryTest {

    private StationRepository stationRepository;

    private LineRepository lineRepository;

    @BeforeEach
    public void initStationRepository() {
        stationRepository = new StationRepository();

        lineRepository = ManageControllerTest.initializeWithEmptyStations().lines();
    }

    @Test
    @DisplayName("중복되지 않은 역 추가")
    public void addStation_NotDuplicateStation_StationAdded() {

        // given
        stationRepository = stationRepository.addStation("강남역");

        // when
        stationRepository = stationRepository.addStation("봉천역");

        //then
        assertThat(stationRepository.stations())
                .extracting(Station::getName)
                .containsExactly("강남역", "봉천역");
    }

    @Test
    @DisplayName("여러 역을 한 번에 추가")
    public void addStations_NotDuplicateStations_StationsAdded() {

        // when
        stationRepository = stationRepository.addStations("봉천역", "강남역", "잠실역");

        //then
        assertThat(stationRepository.stations())
                .extracting(Station::getName)
                .containsExactly("봉천역", "강남역", "잠실역");
    }

    @Test
    @DisplayName("중복된 역 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        stationRepository = stationRepository.addStation("강남역");

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.addStation("강남역");

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DUPLICATE_NAME_ERROR, "강남역");
    }

    @Test
    @DisplayName("기존 역 삭제")
    public void removeStation_OldStation_EmptyStations() {

        // given
        stationRepository = stationRepository.addStation("신림역");

        // when
        stationRepository = stationRepository.removeStation("신림역", lineRepository);

        //then
        assertThat(stationRepository.stations()).isEmpty();
    }

    @Test
    @DisplayName("존재하지 않는 역 삭제 시 예외 발생")
    public void removeStation_DoesNotExistStation_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.removeStation("신림역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DOES_NOT_EXIST_ERROR, "신림역");
    }

    @Test
    @DisplayName("노선에 등록되어 있는 역 삭제 시 예외 발생")
    public void removeStation_StationSavedAtLine_ExceptionThrown() {

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.removeStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.SAVED_AT_LINE_ERROR, "강남역");
    }
}