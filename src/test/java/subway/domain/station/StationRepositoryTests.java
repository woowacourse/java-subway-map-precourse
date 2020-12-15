package subway.domain.station;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StationRepositoryTests {
    @Test
    public void 중복_이름_테스트() {
        String stationName = "Repository station";
        Station station = new Station(stationName);
        Station sameNameStation = new Station(stationName);
        StationRepository.addStation(station);

        assertThat(StationRepository.isExistent(station))
                .isTrue();
        assertThat(StationRepository.isExistent(sameNameStation))
                .isTrue();
    }
}
