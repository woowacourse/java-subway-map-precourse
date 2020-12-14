package subway;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
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
        loadInitStationData();
        loadInitLineData();
        loadInitSectionData();
    }

    private void loadInitStationData() {
        InitConstants.STATION_LIST.forEach(name -> stationRepository.addStation(new Station(name)));
    }

    private void loadInitLineData() {
        InitConstants.LINE_LIST.forEach(name -> lineRepository.addLine(new Line(name)));
    }

    private void loadInitSectionData() {
        for (Entry<String, List<String>> sectionsEntry : InitConstants.SECTION_LIST.entrySet()) {
            List<Station> stations = sectionsEntry.getValue().stream()
                .map(stationRepository::findByName)
                .collect(Collectors.toList());
            Line line = lineRepository.findByName(sectionsEntry.getKey());
            sectionRepository.addStationList(line, stations);
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
