package subway.domain.line;

import subway.domain.line.Line;
import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.domain.station.StationRepository;

import java.util.*;

public class LineRepository {
    private static final String LINE_DUPLICATE_ERROR = "[ERROR] 이미 등록되어 있는 노선입니다.";
    private static final String LINE_EXIST_ERROR = "[ERROR] 등록되어 있는 노선이 아닙니다.";
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(LineName lineName, StationName firstStationName, StationName lastStationName) {
        validateDuplicate(lineName);
        Line line = new Line(lineName);
        Station firstStation = new Station(firstStationName);
        Station lastStation = new Station(lastStationName);
        line.init(firstStation, lastStation);
        lines.add(line);
    }

    private static void validateDuplicate(LineName lineName) {
        Set<Line> duplicateCheckSet = new HashSet<>(lines);
        duplicateCheckSet.add(new Line(lineName));
        if (duplicateCheckSet.size() == lines.size()) {
            throw new IllegalArgumentException(LINE_DUPLICATE_ERROR);
        }
    }

    public static boolean deleteLineByName(LineName lineName) {
        validateNameExist(lineName);
        return lines.removeIf(line -> Objects.equals(line.getName(), lineName));
    }

    public static void validateNameExist(LineName lineName) {
        if (!lines.contains(new Line(lineName))) {
            throw new IllegalArgumentException(LINE_EXIST_ERROR);
        }
    }

//    public static Line getLineByName(String name) {
//        Line inputLine = new Line(name);
//        for (Line line : lines) {
//            if (line.equals(inputLine)) {
//                return line;
//            }
//        }
//        throw new IllegalArgumentException(LINE_EXIST_ERROR);
//    }


}
