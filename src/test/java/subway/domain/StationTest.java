package subway.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void 역_검색을_성공한다() throws Exception {
        //given
        Station station = new Station("서울역");
        StationRepository.addStation(station);

        //when
        List<Station> stations = StationRepository.stations();
        Optional<Station> findStation = stations.stream()
                .filter(st -> st.getName().equals("서울역"))
                .findAny();

        //then
        assertThat(findStation.orElse(null)).isEqualTo(station);
    }

    @Test
    public void 역_검색을_실패한다() throws Exception {
        //given
        Station station = new Station("서울역");
        StationRepository.addStation(station);

        //when
        List<Station> stations = StationRepository.stations();
        Optional<Station> findStation = stations.stream()
                .filter(st -> st.getName().equals("부산역"))
                .findAny();

        //then
        assertThat(findStation.orElse(null)).isNull();
    }

    @Test
    public void 역_삭제를_성공한다() throws Exception {
        //given
        Station station = new Station("서울역");
        StationRepository.addStation(station);

        //when
        boolean isDelete = StationRepository.deleteStation("서울역");

        //then
        assertThat(isDelete).isTrue();
    }

    @Test
    public void 역_삭제를_실패한다() throws Exception {
        //given
        Station station = new Station("서울역");
        StationRepository.addStation(station);

        //when
        boolean isDelete = StationRepository.deleteStation("서현역");

        //then
        assertThat(isDelete).isFalse();
    }
}