package subway.controller;

import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.MenuItemsRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayRepository;
import subway.view.InfoMessage;
import subway.view.Menu;

public class SubwaySystem {
    private MenuInputManager menuInputManager;
    private StationSystem stationSystem;
    private LineSystem lineSystem;
    private PathSystem pathSystem;

    public SubwaySystem(Scanner scanner) {
        menuInputManager = new MenuInputManager(scanner);
        stationSystem = new StationSystem(scanner, menuInputManager);
        lineSystem = new LineSystem(scanner, menuInputManager);
        pathSystem = new PathSystem(scanner, menuInputManager);
        initInfo();
    }

    //TODO : refactor  - 다음 작업을 하기위한 임시 초기화 방식
    private void initInfo() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
        String[] line2  = {"2호선", "교대역","역삼역"};
        String[] line3  = {"3호선", "교대역","매봉역"};
        String[] lineShin  = {"신분당선", "강남역","양재시민의숲역"};
        SubwayRepository.createSubwayRealLine(line2);
        SubwayRepository.addPathByLineName("2호선",1, "강남역");
        SubwayRepository.createSubwayRealLine(line3);
        SubwayRepository.getPathByLineName("3호선").addPath(1, "남부터미널역");
        SubwayRepository.getPathByLineName("3호선").addPath(2, "양재역");
        SubwayRepository.createSubwayRealLine(lineShin);
        SubwayRepository.getPathByLineName("신분당선").addPath(1, "양재역");
    }

    public void run() {
        while (true) {
            Menu.printMenu(MenuItemsRepository.getMainItems());
            String input = menuInputManager.getMainInput();
            if (input.equals("Q")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            stationSystem.run();
        }
        if (input.equals("2")) {
            lineSystem.run();
        }
        if (input.equals("3")) {
            pathSystem.run();
        }
        if (input.equals("4")) {
            printSubwayMap();
        }
    }

    private void printSubwayMap() {
        Menu.printSubwayMap();
        for(Line line: LineRepository.lines()){
            InfoMessage.printName(line.getName());
            InfoMessage.printName("---");
            for(Station station : SubwayRepository.getPathByLine(line).getPath()){
                InfoMessage.printName(station.getName());
            }
            System.out.println();
        }
    }
}
