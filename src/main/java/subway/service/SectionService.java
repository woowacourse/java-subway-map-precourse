package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;

public class SectionService {

    public static void addSection(String lineName, String index, String stationName) {
        LineRepository.findLineByName(lineName).addStation(index, stationName);
    }

    public static void removeSection(String stationName, String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        line.removeStation(stationName);
    }

}
