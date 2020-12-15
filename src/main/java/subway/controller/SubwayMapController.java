package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.MainConsole;
import subway.view.MainMenu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubwayMapController {
    private List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역"
                                                    ,"양재역", "양재시민의숲역", "매봉역");
    private List<String> lines = Arrays.asList("2호선", "3호선", "신분당선");
    private MainConsole mainConsole;
    private final Scanner scanner;

    public SubwayMapController(Scanner scanner) {
        this.scanner = scanner;
        this.mainConsole = new MainConsole();
        onStart();
    }

    public void run() {
        while (true) {
            mainConsole.showMenu();
            MainMenu.MainView selector = mainConsole.selectMenu();
            if (selector == MainMenu.MainView.QUIT) {
                break;
            }
            selector.moveNext(selector.getKey());
        }
    }

    private void onStart() {
        stations.forEach(station -> StationRepository.addStation(new Station(station)));
        addLineTwo();
        addLineThree();
        addLineShin();
    }

    private void addLineTwo() {
        Line lineTwo = new Line(lines.get(0));
        lineTwo.addStations(stations.get(0), stations.get(1), stations.get(2));
        LineRepository.addLine(lineTwo);
    }

    private void addLineThree() {
        Line lineThree = new Line(lines.get(1));
        lineThree.addStations(stations.get(0), stations.get(3), stations.get(4), stations.get(6));
        LineRepository.addLine(lineThree);
    }

    private void addLineShin() {
        Line lineShin = new Line(lines.get(2));
        lineShin.addStations(stations.get(1), stations.get(4), stations.get(5));
        LineRepository.addLine(lineShin);
    }
}
