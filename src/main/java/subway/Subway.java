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

public class Subway {

    private final StationRepository stationRepository = new StationRepository();
    private final LineRepository lineRepository = new LineRepository();
    private final SectionRepository sectionRepository = new SectionRepository();

    public Subway() {
        loadInitData();
    }

    public void launch(Scanner scanner) {
        MainView mainView = new MainView(scanner, this);
        mainView.start();
    }

    private void loadInitData() {
        loadInitStationData(InitConstants.STATION_LIST, stationRepository);
        loadInitLineData(InitConstants.LINE_LIST, lineRepository);
        loadInitSectionData(InitConstants.LINE_TITLE_GREEN_TEXT,
            InitConstants.STATION_IN_GREEN_LINE_LIST, sectionRepository);
        loadInitSectionData(InitConstants.LINE_TITLE_ORANGE_TEXT,
            InitConstants.STATION_IN_ORANGE_LINE_LIST, sectionRepository);
        loadInitSectionData(InitConstants.LINE_TITLE_SHINBUNDANG_TEXT,
            InitConstants.STATION_IN_SHINBUNDANG_LINE_LIST, sectionRepository);
    }

    private void loadInitStationData(String[] stationNames, StationRepository stations) {
        for (String stationName : stationNames) {
            stations.addStation(new Station(stationName));
        }
    }

    private void loadInitLineData(String[] lineNames, LineRepository lines) {
        for (String lineName : lineNames) {
            lines.addLine(new Line(lineName));
        }
    }

    private void loadInitSectionData(String lineName, String[] stationNames,
        SectionRepository subwayMap) {
        List<Station> initLineStations = new ArrayList<>();
        for (String stationName : stationNames) {
            initLineStations.add(stationRepository.findByName(stationName));
        }
        subwayMap.addStationList(lineRepository.findByName(lineName), initLineStations);
    }

    public StationRepository getStationRepository() {
        return stationRepository;
    }

    public LineRepository getLineRepository() {
        return lineRepository;
    }

    public SectionRepository getSectionRepository() {
        return sectionRepository;
    }
}
