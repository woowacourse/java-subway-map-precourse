package subway.domain.station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryStationRepositoryTest {

    private StationRepository stationRepository;

    @BeforeEach
    void init() {
        stationRepository = MemoryStationRepository.of();
    }

    @Test
    @DisplayName("지하철 역 저장 확인 ")
    void testSave() {
        //given
        Station incheonStation = Station.of("인천시청역");
        Station seoulStation = Station.of("서울시청역");

        //when
        Station savedIncheonStation = stationRepository.addStation(incheonStation);
        Station savedSeroulStation = stationRepository.addStation(seoulStation);

        //then
        assertThat(savedIncheonStation.getName()).isEqualTo(incheonStation.getName());
        assertThat(savedSeroulStation.getName()).isEqualTo(seoulStation.getName());
    }

    @Test
    @DisplayName("지하철 역 삭제 테스트")
    void testDelete() {
        //given
        Station station = Station.of("구로역");

        //when
        stationRepository.addStation(station);
        stationRepository.deleteStationByName(station.getName());
        List<Station> stations = stationRepository.stations();

        //then
        assertThat(stations.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("저장되지 않은 지하철 역일 시 false를 반환한다.")
    void testDeleteFail() {
        //given
        Station station = Station.of("구로역");

        //when
        boolean isDelete = stationRepository.deleteStationByName(station.getName());

        //then
        assertThat(isDelete).isEqualTo(false);
    }
}