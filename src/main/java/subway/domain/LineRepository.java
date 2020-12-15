package subway.domain;

import subway.Constant;

import java.util.*;

public class LineRepository {
    public static final List<Line> lines = new ArrayList<>();
    static StationRepository stationRepository = new StationRepository();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLines(List<Line> lineList){
        lineList.forEach(line -> lines.add(line));
    }

    public static void addLine(String lineName, String upwardName, String downwardName) {
        if (stationRepository.checkNameLength(lineName)) {
            throw new IllegalStateException();
        }
        if (checkExistLine(lineName) || !stationRepository.checkExistStation(upwardName)
                || !stationRepository.checkExistStation(downwardName) || upwardName.equals(downwardName)) {
            throw new IllegalArgumentException();
        }
        Line line = new Line(lineName);
        line.stations.add(new Station(upwardName));
        line.stations.add(new Station(downwardName));
        lines.add(line);
    }

    public static boolean deleteLineByName(String lineName) {
        if (!checkExistLine(lineName)) {
            throw new IllegalArgumentException();
        }
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }

    public static boolean checkExistLine(String lineName) {
        return lines.stream().anyMatch(o -> o.getName().equals(lineName));
    }

}
