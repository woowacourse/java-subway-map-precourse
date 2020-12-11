package subway.view;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {


    @Test
    @Description("printLines 확인")
    public void printLinesTest() {

        LineRepository lineRepository = new LineRepository();
        List<Line> lines = lineRepository.lines();

        OutputView.printLines(lines);

    }

    @Test
    @Description("printStation 확인")
    public void printStationTest() {

        StationRepository stationRepository = new StationRepository();

        List<Station> stations = stationRepository.stations();
        OutputView.printStations(stations);

    }

}