package subway.view;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.*;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @BeforeAll
    public void init(){
        InputView.initScanner(new Scanner(System.in));
    }

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
        OutputView.printStations(stations,StationMenu.SEARCH);

    }

    @Test
    @Description("printMenu 확인")
    public void printMenu() {

        Menu main = MainMenu.LINE;
        OutputView.printMenu(main);

        Menu section = SectionMenu.DELETE;
        OutputView.printMenu(section);

        LineMenu lineMenu = LineMenu.BACK;
        OutputView.printMenu(lineMenu);

        StationMenu back = StationMenu.BACK;
        OutputView.printMenu(back);

    }

    @Test
    @Description("printMap 확인")
    public void printMapTest() {

        LineRepository lineRepository = new LineRepository();

        OutputView.printMap(lineRepository.lines());

    }

}