package subway.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        stationRepository.addStation(new Station("강남역"));

        // when
        boolean isAdded = stationRepository.addStation(new Station("봉천역"));

        //then
        assertThat(isAdded).isTrue();
    }

    @Test
    @DisplayName("중복된 역 추가 시 예외 발생")
    public void addStation_DuplicateStation_ExceptionThrown() {

        // given
        stationRepository.addStation(new Station("강남역"));

        // when
        boolean isAdded = stationRepository.addStation(new Station("강남역"));

        //then
        assertThat(isAdded).isFalse();
    }
}