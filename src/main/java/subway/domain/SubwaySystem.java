package subway.domain;

import java.util.Scanner;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.menu.MenuItemsRepository;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuOutputManager;
import subway.domain.path.PathService;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.line.LineService;
import subway.domain.station.StationService;
import subway.common.InfoMessage;
import subway.common.GuideMessage;

public class SubwaySystem {
    private MenuInputManager menuInputManager;
    private StationService stationService;
    private LineService lineService;
    private PathService pathService;

    public SubwaySystem(Scanner scanner) {
        menuInputManager = new MenuInputManager(scanner);
        stationService = new StationService(scanner, menuInputManager);
        lineService = new LineService(scanner, menuInputManager);
        pathService = new PathService(scanner, menuInputManager);
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
            MenuOutputManager.printMenu(MenuItemsRepository.getMainItems());
            String input = menuInputManager.getMainInput();
            if (input.equals("Q")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            stationService.run();
        }
        if (input.equals("2")) {
            lineService.run();
        }
        if (input.equals("3")) {
            pathService.run();
        }
        if (input.equals("4")) {
            printSubwayMap();
        }
    }

    private void printSubwayMap() {
        GuideMessage.print(SubwayOutputManager.SUBWAY_MAP);
        for(Line line: LineRepository.lines()){
            InfoMessage.print(line.getName());
            InfoMessage.print("---");
            for(Station station : SubwayRepository.getPathByLine(line).getPath()){
                InfoMessage.print(station.getName());
            }
            System.out.println();
        }
    }
}
