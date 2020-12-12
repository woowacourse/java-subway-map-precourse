package subway.domain.station.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationServiceTest {

    @AfterEach
    void tearDown() {
        StationRepository.deleteAll();
    }

    @DisplayName("station을 추가하는 기능을 테스트한다")
    @Test
    void testRegisterStation() {
        //given
        Station station = new Station("강남역");

        //when
        StationService.registerStation(station);

        //thent
        List<Station> stations = StationRepository.stations();
        assertThat(stations)
                .extracting("name", String.class)
                .contains("강남역");
    }

    @DisplayName("중복되는 이름의 station을 추가하면 예외를 발생시킨다.")
    @Test
    void testAddStationIfRegisterDuplicatedStationName() {
        //given
        Station station = new Station("강남역");
        StationService.registerStation(station);
        Station duplicatedStation = new Station("강남역");

        //when //then
        assertThatThrownBy(() -> StationService.registerStation(duplicatedStation))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
