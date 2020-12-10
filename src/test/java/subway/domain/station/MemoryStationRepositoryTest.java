package subway.domain.station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Station incheonStation = Station.of("인천시청");
        Station seoulStation = Station.of("서울시청");

        //when
        stationRepository.addStation(incheonStation);
        stationRepository.addStation(seoulStation);
        Station findIncheonStation = stationRepository.findByName(incheonStation.getName());
        Station findSeoulStation = stationRepository.findByName(seoulStation.getName());

        //then
        assertThat(findIncheonStation.getName()).isEqualTo(incheonStation.getName());
        assertThat(findSeoulStation.getName()).isEqualTo(seoulStation.getName());
    }
}