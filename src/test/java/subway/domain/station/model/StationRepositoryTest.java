package subway.domain.station.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StationRepositoryTest {

    @AfterEach
    void tearDown() {
        StationRepository.deleteAll();
    }

    @DisplayName("station을 추가하는 기능을 테스트한다")
    @Test
    void testAddStation() {
        //given
        Station station = new Station("강남역");

        //when
        StationRepository.addStation(station);

        //thent
        List<Station> stations = StationRepository.stations();
        assertThat(stations)
                .extracting("name", String.class)
                .contains("강남역");
    }
}
