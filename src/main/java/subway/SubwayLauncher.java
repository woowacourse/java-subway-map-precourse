package subway;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.InitConstants;
import subway.view.MainView;

public class SubwayLauncher {

    public static StationRepository stations = new StationRepository();
    public static LineRepository lines = new LineRepository();
    public static SectionRepository subwayMap = new SectionRepository();

    private static boolean systemState = true;

    public SubwayLauncher() {
        setInitData();
    }

    public void launch(Scanner scanner) {
        MainView showScreen = new MainView(scanner);
        while (this.systemState) {
            this.systemState = showScreen.start();
        }
    }

    private void setInitData() {
        initStationGenerator(InitConstants.STATION_LIST, stations);
        initLineGenerator(InitConstants.LINE_LIST, lines);
        initSectionGenerator(InitConstants.LINE_TITLE_GREEN_TEXT,
            InitConstants.STATION_IN_GREEN_LINE_LIST, subwayMap);
        initSectionGenerator(InitConstants.LINE_TITLE_ORANGE_TEXT,
            InitConstants.STATION_IN_ORANGE_LINE_LIST, subwayMap);
        initSectionGenerator(InitConstants.LINE_TITLE_SHINBUNDANG_TEXT,
            InitConstants.STATION_IN_SHINBUNDANG_LINE_LIST, subwayMap);
    }

    private void initStationGenerator(String[] stationNames, StationRepository stations) {
        for (String stationName : stationNames) {
            stations.addStation(new Station(stationName));
        }
    }

    private void initLineGenerator(String[] lineNames, LineRepository lines) {
        for (String lineName : lineNames) {
            lines.addLine(new Line(lineName));
        }
    }

    private void initSectionGenerator(String lineName, String[] stationNames,
        SectionRepository subwayMap) {
        List<Station> initLineStations = new ArrayList<>();
        for (String stationName : stationNames) {
            initLineStations.add(stations.findByName(stationName));
        }
        subwayMap.addStationList(lines.findByName(lineName), initLineStations);
    }
}
