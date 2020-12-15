package subway;

import java.util.Arrays;
import subway.InitData.InitLine;
import subway.InitData.InitStation;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.MainDisplay;

public class SubwayMap {

    private SubwayMap() {
        init();
    }

    public static SubwayMap newSubwayMap() {
        return new SubwayMap();
    }

    public void init() {
        try {
            Arrays.stream(InitStation.values())
                .forEach(stationName -> initStations(stationName));
            Arrays.stream(InitLine.values())
                .forEach(initLine -> initLines(initLine));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 초기 설정을 실패했습니다.");
        }
    }

    public void runnable() {
        MainDisplay.loadMainMenu();
    }

    private void initStations(InitStation stationName) {
        Station station = Station.newStationWithName(stationName.toString());
        StationRepository.addStation(station);
    }

    private void initLines(InitLine initLine) {
        Line line = Line.newLineWithName(initLine.getInitLineName());
        Section section = Section.newSectionWithLine(line);
        initLine.getInitStations().stream().forEach(initStation -> section.getStations()
            .add(StationRepository.getStationByName(initStation.toString())));
        SectionRepository.addSection(section);
        LineRepository.addLine(line);
    }
}
