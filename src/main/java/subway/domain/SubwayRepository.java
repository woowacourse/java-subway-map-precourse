package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.path.PathRepository;
import subway.domain.station.Station;

public class SubwayRepository {
    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();
    private static final int END_POINT_ONLY_EXIST = 2;

    public static void createSubwayRealLine(String[] lineInfo) {
        Line newline = new Line(lineInfo[0]);
        LineRepository.addLine(newline);
        PathRepository path = new PathRepository(lineInfo[1], lineInfo[2]);
        subwayRealLines.put(newline, path);
    }

    public static List<Station> getPathByLine(Line line) {
        return subwayRealLines.get(line).getPath();
    }

    public static void addPathByLineNameAndIndex(String[] pathInfo) {
        String lineName = pathInfo[0];
        String station = pathInfo[1];
        int index = Integer.parseInt(pathInfo[2]) - 1;
        Line line = LineRepository.findLineByName(lineName);
        PathRepository pathRepository = subwayRealLines.get(line);
        pathRepository.addPath(index, station);
    }

    public static void deleteSubwayLineByName(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        subwayRealLines.remove(line);
    }

    public static boolean isUnacceptableIndexSize(String lineName, int index) {
        return getSizeOfPathByLineName(lineName) + 1 < index;
    }

    public static boolean isOnlyEndsRemained(String lineName) {
        return getSizeOfPathByLineName(lineName) == END_POINT_ONLY_EXIST;
    }

    public static boolean containsStationOnPathInTheLine(String station, String lineName) {
        return getPathByLineName(lineName).containsStationByName(station);
    }

    public static boolean containsStationOnPath(String stationName) {
        for (PathRepository path : subwayRealLines.values()) {
            if (path.containsStationByName(stationName)) {
                return true;
            }
        }
        return false;
    }

    public static void deleteStationOnPathByLineName(String[] pathInfo) {
        String lineName = pathInfo[0];
        String stationName = pathInfo[1];
        getPathByLineName(lineName).deletePathByName(stationName);
    }

    private static PathRepository getPathByLineName(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        return subwayRealLines.get(line);
    }

    private static int getSizeOfPathByLineName(String lineName) {
        return getPathByLineName(lineName).pathSize();
    }

}
