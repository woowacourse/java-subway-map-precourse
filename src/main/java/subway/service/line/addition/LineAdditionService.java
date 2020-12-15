package subway.service.line.addition;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;
import subway.repository.LineRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.line.LineInformationView;

import java.util.LinkedList;

public class LineAdditionService {
    public static LinkedList<Station> addStationNames(String upStationName, String downStationName) {
        LinkedList<Station> stationNames = new LinkedList<>();

        stationNames.add(new Station(upStationName));
        stationNames.add(new Station(downStationName));
        return stationNames;
    }

    public static void addLineByStationNames(String lineName, LinkedList<Station> stationNames) {
        Line line = addLineByLineName(lineName);
        TransitMapRepository.addTransitMap(new TransitMap(line, stationNames));
        LineInformationView.printLineAdditionInformation();
        System.out.println();
    }

    public static Line addLineByLineName(String lineName) {
        Line line = new Line(lineName);

        LineRepository.addLine(line);
        return line;
    }
}
