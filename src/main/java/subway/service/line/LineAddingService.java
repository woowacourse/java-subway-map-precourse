package subway.service.line;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.TransitMap;
import subway.repository.LineRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.line.LineInformationView;

import java.util.LinkedList;

public class LineAddingService {
    public static LinkedList<Station> addStationNames(String upStationName, String downStationName) {
        LinkedList<Station> stationNames = new LinkedList<>();

        stationNames.add(new Station(upStationName));
        stationNames.add(new Station(downStationName));
        return stationNames;
    }

    public static Line addLineName(String lineName) {
        Line line = new Line(lineName);

        LineRepository.addLine(line);
        return line;
    }

    public static void addNames(String lineName, LinkedList<Station> stationNames) {
        Line line = addLineName(lineName);

        TransitMapRepository.addTransitMap(new TransitMap(line, stationNames));
        LineInformationView.printLineAddingInformation();
        System.out.println();
    }
}
