package subway.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StationTest {

    @Test
    public void 역을_등록한다() throws Exception {
        //given
        Station station = new Station("서울역");

        //when
        StationRepository.addStation(station);

        //then
        List<Station> stations = StationRepository.stations();
        assertThat(stations.size()).isEqualTo(1);
    }
}