package subway.service;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.userinterface.mainmenu.MainMenuView;

import java.util.Scanner;

public class SubwayApplication {

    private static final StationService stationService = new StationService();
    private static final LineService lineService = new LineService();
    private static final IntervalService intervalService = new IntervalService();
    private static String userSelectMenu = "";

    public static void init() {
        initStation();
        initLine();
        initInterval();
    }

    private static void initStation() {
        stationService.registerStation("교대역");
        stationService.registerStation("강남역");
        stationService.registerStation("역삼역");
        stationService.registerStation("남부터미널역");
        stationService.registerStation("양재역");
        stationService.registerStation("양재시민의숲역");
        stationService.registerStation("매봉역");
    }

    private static void initLine() {
        lineService.registerLine("2호선", StationRepository.findStationByName("교대역"),
                StationRepository.findStationByName("역삼역"));
        lineService.registerLine("3호선", StationRepository.findStationByName("교대역"),
                StationRepository.findStationByName("매봉역"));
        lineService.registerLine("신분당선", StationRepository.findStationByName("강남역"),
                StationRepository.findStationByName("양재시민의숲역"));
    }

    private static void initInterval() {
        intervalService.registerInterval(LineRepository.findLineByName("2호선"),
                StationRepository.findStationByName("강남역"), 2);
        intervalService.registerInterval(LineRepository.findLineByName("3호선"),
                StationRepository.findStationByName("남부터미널역"), 2);
        intervalService.registerInterval(LineRepository.findLineByName("3호선"),
                StationRepository.findStationByName("양재역"), 3);
        intervalService.registerInterval(LineRepository.findLineByName("신분당선"),
                StationRepository.findStationByName("양재역"), 2);
    }

    public static void run(Scanner scanner) {
        init();

        while (!userSelectMenu.equals("Q")) {
            try {
                MainMenuView.getInstance().printMenu();
                userSelectMenu = MainMenuView.getInstance().getUserInput(scanner);
                MainService.getInstance().selectMenu(MainMenuView.mainMenu, userSelectMenu, scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
