package subway;

import subway.controller.MainMenuController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class SubwayManager {
    private static final String[] INITIAL_STATIONS =
        {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_SINBUNDANG = "신분당선";
    private static final String[] LINE_TWO_STATIONS = {"교대역", "강남역", "역삼역"};
    private static final String[] LINE_THREE_STATIONS = {"교대역", "남부터미널역", "양재역", "매봉역"};
    private static final String[] LINE_SINBUNDANG_STATIONS = {"강남역", "양재역", "양재시민의숲역"};
    private static final int UPWARD_END_STATION_ORDER = 0;

    public SubwayManager() {
        settingInitialSubways();
    }

    public void run(Scanner scanner) {
        MainMenuController mainMenuController = MainMenuController.getInstance();
        mainMenuController.mappingMainMenu(scanner);
    }

    private void settingInitialSubways() {
        settingInitialStations();

        settingInitialLines(LINE_TWO, LINE_TWO_STATIONS);
        settingInitialLines(LINE_THREE, LINE_THREE_STATIONS);
        settingInitialLines(LINE_SINBUNDANG, LINE_SINBUNDANG_STATIONS);
    }

    private void settingInitialStations() {
        Arrays.stream(INITIAL_STATIONS)
            .map(Station::new)
            .forEach(StationRepository::addStation);
    }

    private void settingInitialLines(String lineName, String[] stationNames) {
        Line line = new Line(lineName);
        addStationInLine(line, stationNames);
        LineRepository.addLine(line);
    }

    private void addStationInLine(Line line, String[] stationNames) {
        int order = UPWARD_END_STATION_ORDER;
        for (String stationName : stationNames) {
            line.addLineStation(order, new Station(stationName));
            order++;
        }
    }
}
