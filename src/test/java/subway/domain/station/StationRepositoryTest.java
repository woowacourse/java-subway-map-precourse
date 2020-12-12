package subway.domain.station;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("지하철역 StationRepositoryTest")
public class StationRepositoryTest {

    private final String name="station name";

    @AfterEach
    void after(){
        StationRepository.deleteAll();
    }

    @DisplayName("지하철 역 등록")
    @Test
    void addStation(){
        Station station=new Station(name);
        StationRepository.addStation(station);

        int expectSize=1;
        assertEquals(StationRepository.stations().size(),expectSize);
    }

    @DisplayName("지하철 역 삭제")
    @Test
    void deleteStation(){
        Station station=new Station(name);
        StationRepository.addStation(station);

        int expectSize=1;
        assertEquals(StationRepository.stations().size(),expectSize);
        expectSize=0;
        StationRepository.deleteStation(name);
        assertEquals(StationRepository.stations().size(),expectSize);
    }

    @DisplayName("노선에 등록된 역은 삭제할 수 없다.")
    @Test
    void printAllStationException(){
        String lineName="line name";
        Line line=new Line(lineName);
        line.addAllStation(name);
        LineRepository.addLine(line);
        assertEquals(StationRepository.deleteStation(name),false);
    }

    @DisplayName("중복된 지하철 역 이름은 등록될 수 없다.")
    @Test
    void duplicateStationException(){
        Station station=new Station(name);
        StationRepository.addStation(station);
        assertEquals(StationRepository.addStation(station),false);
    }

    @DisplayName("지하철 역 이름은 2글자 이상이어야 한다.")
    @Test
    void stationNameLimitException(){
        String errorName="a";
        Station station=new Station(errorName);
        assertEquals(StationRepository.addStation(station),false);
    }
}
