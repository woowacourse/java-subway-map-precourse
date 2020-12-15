package subway.repository;

import subway.domain.Line;

import java.util.*;

public class SectionRepository {
    private static LineRepository lineRepository = new LineRepository();
    private static StationRepository stationRepository = new StationRepository();

    public static void addSection(String lineName, String stationName, int order) {
        if (!validate(lineName, stationName)) {
            throw new IllegalArgumentException();
        }
        try {
            Line targetLine = lineRepository.lines.stream().filter(l -> lineName.equals(l.getName())).findFirst().get();
            if (targetLine.existStation(stationName)) {
                throw new IllegalStateException();
            }
            targetLine.addStation(stationName, order);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static boolean deleteSection(String lineName, String stationName) {
        if (!validate(lineName, stationName)) {
            throw new IllegalArgumentException();
        }
        Line line = lineRepository.lines.stream().filter(l -> lineName.equals(l.getName())).findFirst().get();
        if (line.checkStationSize()) {
            throw new IllegalStateException();
        }
        return line.stations.removeIf(s -> Objects.equals(s.getName(), stationName));
    }

    static boolean validate(String lineName, String stationName) {
        if (!lineRepository.checkExistLine(lineName) || !stationRepository.checkExistStation(stationName)) {
            return false;
        }
        return true;
    }

}
