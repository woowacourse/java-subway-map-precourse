package subway.domain;

import java.util.LinkedList;
import java.util.Objects;

public class SectionRepository {

    public static void addSection(String lineName, String stationName, int sequence) {
        LinkedList<Station> line = LineRepository.findLine(lineName).getLine();
        Station station = StationRepository.findStation(stationName);
        line.add(sequence, station);
    }

//    public static boolean deleteSectionByName(String name) {
//    }
}
