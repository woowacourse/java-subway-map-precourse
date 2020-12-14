package subway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
        MainView mainView = new MainView(this, scanner);
        mainView.start();
    }

    private void loadInitData() {
        loadInitStationData(InitConstants.STATION_LIST);
        loadInitLineData(InitConstants.LINE_LIST);
        loadInitSectionData(InitConstants.SECTION_LIST);
    }

    private void loadInitStationData(List<String> stationNames) {
        for (String stationName : stationNames) {
            this.stationRepository.addStation(new Station(stationName));
        }
    }

    private void loadInitLineData(List<String> lineNames) {
        for (String lineName : lineNames) {
            this.lineRepository.addLine(new Line(lineName));
        }
    }

    private void loadInitSectionData(Map<String, List<String>> sections) {
        for (Entry<String, List<String>> sectionsEntry : sections.entrySet()) {
            List<Station> stations = new ArrayList<>();
            for (String stationName : sectionsEntry.getValue()) {
                stations.add(this.stationRepository.findByName(stationName));
            }
            Line line = this.lineRepository.findByName(sectionsEntry.getKey());
            this.sectionRepository.addStationList(line, stations);
        }
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
