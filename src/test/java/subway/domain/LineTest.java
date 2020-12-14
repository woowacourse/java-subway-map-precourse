package subway.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    Station station1 = new Station("인천논현역");
    Station station2 = new Station("논현역");
    Station station3 = new Station("호구포역");
    Station station4 = new Station("소래역");

    @Test
    @DisplayName("노선에 같은 역을 중복해서 삽입하려 할 때 예외 발생")
    void addLineStation() {
        StationRepository.addStation(station1);
        Line line = new Line("수인선");
        line.addLineStation(station1);
        line.addLineStation(station1);
    }

    @Test
    @DisplayName("하행 종점에는 입력할 때 예외 발생")
    void testAddLineStation() {
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        Line line = new Line("수인선");
        line.addLineStation(station1);
        line.addLineStation(0, station2);
    }

    @Test
    @DisplayName("하행 종점에는 입력할 때 예외 발생")
    void test2AddLineStation() {
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        Line line = new Line("수인선");
        line.addLineStation(station1);
        line.addLineStation(station2);
        line.addLineStation(2, station3);
    }

    @Test
    @DisplayName("아예 이상한 값을 입력할 때 예외 발생")
    void test3AddLineStation() {
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        Line line = new Line("수인선");
        line.addLineStation(station1);
        line.addLineStation(station2);
        line.addLineStation(6, station3);
    }

    @Test
    @DisplayName("삭제할 역이 노선에 없을 때 예외 발생")
    void deleteLineStation() {
        StationRepository.addStation(station1);
        StationRepository.addStation(station2);
        StationRepository.addStation(station3);
        Line line = new Line("수인선");
        line.addLineStation(station1);
        line.addLineStation(station2);
        line.addLineStation(station3);
        line.deleteLineStation("강남역");
    }

}
