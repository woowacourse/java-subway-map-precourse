package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationRepositoryTest {

    @Test
    @DisplayName("이미 존재하는 역을 추가할 때 예외 발생")
    void addStation() {
        Station station1 = new Station("인천논현역");
        Station station2 = new Station("인천논현역");
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
    }

    @Test
    @DisplayName("존재하지 않는 역을 삭제할 때 예외 발생")
    void deleteStation() {
        StationRepository.deleteStation("인천논현역");
    }

    @Test
    @DisplayName("존재하지 않는 역을 get하려할 때 예외 발생")
    void getStation() {
        StationRepository.getStation("인천논현역");
    }
}