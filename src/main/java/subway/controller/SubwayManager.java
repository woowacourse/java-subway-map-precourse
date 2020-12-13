package subway.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayManager implements Message {

    private static final String QUIT = "Q";
    private static final String BACK = "B";
    private final List<String> STATION_NAMES_TO_INIT = Arrays
        .asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private final List<String> LINE_NAMES_TO_INIT = Arrays
        .asList("2호선", "3호선", "신분당선");

    public void run() {
        initializeSubway();
        while (true) {
            OutputView.displayMain();
            String selection = InputView.getSelection();
            if (selection.equalsIgnoreCase(QUIT)) {
                break;
            }
            MainMenu.request(selection);
        }
    }

    private void initializeSubway() {
        initializeStations();
        initializeLines();
        initializeSection("2호선", "교대역", "강남역", "역삼역");
        initializeSection("3호선", "교대역", "남부터미널역", "양재역", "매봉역");
        initializeSection("신분당선", "강남역", "양재역", "양재시민의숲역");
    }

    private void initializeStations() {
        ArrayList<Station> stations = new ArrayList<>();
        STATION_NAMES_TO_INIT.forEach(name -> stations.add(new Station(name)));
        StationRepository.setStations(stations);
    }

    private void initializeLines() {
        ArrayList<Line> lines = new ArrayList<>();
        LINE_NAMES_TO_INIT.forEach(name -> lines.add(new Line(name)));
        LineRepository.setLines(lines);
    }

    private void initializeSection(String lineName, String... stationNames) {
        Line line = LineRepository.getLine(lineName);

        for (String stationName : stationNames) {
            line.addLast(StationRepository.getStation(stationName));
        }
    }

    protected static void manageStation() {
        while (true) {
            OutputView.displayStationManagement();
            String selection = InputView.getSelection();
            if (selection.equalsIgnoreCase(BACK)) {
                break;
            }
            StationManager.request(selection);
        }
    }

    protected static void manageLine() {
        while (true) {
            OutputView.displayLineManagement();
            String selection = InputView.getSelection();
            if (selection.equalsIgnoreCase(BACK)) {
                break;
            }
            LineManager.request(selection);
        }
    }

    protected static void manageSection() {
        while (true) {
            OutputView.displaySectionManagement();
            String selection = InputView.getSelection();
            if (selection.equalsIgnoreCase(BACK)) {
                break;
            }
            SectionManager.request(selection);
        }
    }
}
