package subway.line;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.station.Station;

import static org.junit.jupiter.api.Assertions.*;

class LineRepositoryTest {

    LineRepository repository;

    @BeforeEach
    void setUp() {
        repository = new LineRepository();
    }

    @Test
    void 노선에_등록된_역인지_확인_테스트() {
        // given, when
        String onLineStation1 = "강남역";
        String onLineStation2 = "방배역";

        String notOnLineStation = "교대역";

        String lineName = "2호선";

        // when
//        Line line = new Line(lineName, new Station(onLineStation1), new Station(onLineStation2));
        Line line = Line.of(lineName, onLineStation1, onLineStation2);
        repository.addLine(line);

        // then
        assertTrue(repository.isStationOnLine(onLineStation1));
        assertFalse(repository.isStationOnLine(notOnLineStation));
    }

    @Test
    void 존재하지않는_노선_예외처리_테스트() {
        // given, when
        String lineName = "존재하지않는노선";

        // then
        assertThrows(Exception.class, () -> {
            repository.checkLineExist(lineName);
        });
    }

    @Test
    void findByName_테스트() {
        // given
        String lineName = "2호선";
        String stationName1 = "강남역";
        String stationName2 = "방배역";

        // when

//        Line line = new Line(lineName, new Station(stationName1), new Station(stationName2));
        Line line = Line.of(lineName, stationName1, stationName2);
        repository.addLine(line);

        // then
        assertEquals(lineName, repository.findByName(lineName).getName());
    }

}