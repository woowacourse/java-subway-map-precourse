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
    @DisplayName("존재하는 역 삭제")
    public void deleteStation_ExistStation_EmptyStations() {

        // given
        StationRepository repository = new StationRepository().addStations("봉천역", "강남역", "잠실역");

        LineRepository lineRepository =
                new LineRepository().addLine(new Line(new LineName("1호선"), repository));

        stationRepository = stationRepository.addStation("신림역");

        // when
        stationRepository = stationRepository.removeStation("신림역", lineRepository);

        //then
        assertThat(stationRepository.stations()).isEmpty();
    }

    @Test
    @DisplayName("존재하지 않는 역 삭제 시 예외 발생")
    public void deleteStation_DoesNotExistStation_ExceptionThrown() {

        // given
        StationRepository repository = new StationRepository().addStations("봉천역", "강남역", "잠실역");

        LineRepository lineRepository =
                new LineRepository().addLine(new Line(new LineName("1호선"), repository));

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.removeStation("신림역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.DOES_NOT_EXIST_ERROR, "신림역");
    }

    @Test
    @DisplayName("노선에 등록되어 있는 역 삭제 시 예외 발생")
    public void deleteStation_SavedStationAtLine_ExceptionThrown() {

        // given
        StationRepository repository = new StationRepository().addStations("봉천역", "강남역", "잠실역");

        LineRepository lineRepository =
                new LineRepository().addLine(new Line(new LineName("1호선"), repository));

        // when
        ThrowableAssert.ThrowingCallable callable =
                () -> stationRepository.removeStation("강남역", lineRepository);

        //then
        assertThatIllegalArgumentException().isThrownBy(callable)
                .withMessage(StationRepository.SAVED_AT_LINE_ERROR, "강남역");
    }
}