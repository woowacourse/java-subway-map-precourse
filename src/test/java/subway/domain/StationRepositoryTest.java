package subway.domain;

import org.junit.jupiter.api.Test;
import subway.controllers.StationController;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {
    @Test
    public void testAddStation() {
        Station station = StationMaker.make("강남역");
        StationRepository.addStation(station);
        System.out.println(StationRepository.stations());
        assertThatThrownBy(() -> StationRepository.addStation(station))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testDeleteStation() {
        Station station = StationMaker.make("강남역");
        StationRepository.addStation(station);
        assertThatThrownBy(() -> StationRepository.deleteStation("강남"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testLookupStation() {
        StationRepository.addStation(StationMaker.make("강남역"));
        StationRepository.addStation(StationMaker.make("a"));
        StationRepository.addStation(StationMaker.make("b"));
    }
}