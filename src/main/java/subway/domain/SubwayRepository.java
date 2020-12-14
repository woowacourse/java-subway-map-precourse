package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.path.PathRepository;

public class SubwayRepository {
    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();

    public static Map<Line, PathRepository> getSubwayRealLines() {
        return Collections.unmodifiableMap(subwayRealLines);
    }

    public static void createSubwayRealLine(String[] lineInfo) {
        Line newline = new Line(lineInfo[0]);
        LineRepository.addLine(newline);
        PathRepository path = new PathRepository(lineInfo[1], lineInfo[2]);
        subwayRealLines.put(newline, path);
    }

    public static PathRepository getPathByLine(Line line) {
        return subwayRealLines.get(line);
    }

    public static PathRepository getPathByLineName(String lineName) {
        Line line = LineRepository.findLine(lineName);
        return subwayRealLines.get(line);
    }

    public static void addPathByLineName(String[] pathInfo) {
        String lineName = pathInfo[0];
        int index = Integer.parseInt(pathInfo[1]);
        String station = pathInfo[2];
        Line line = LineRepository.findLine(lineName);
        PathRepository pathRepository = subwayRealLines.get(line);
        pathRepository.addPath(index, station);
    }

    public static void deleteSubwayLineByName(String lineName) {
        Line line = LineRepository.findLine(lineName);
        // PATH 등록된 역정보도 삭제해야함.
        subwayRealLines.remove(line);
    }

    public static int getSizeOfPathByLineName(String lineName) {
        return getPathByLineName(lineName).pathSize();
    }

    public static boolean containsStationOnLine(String station, String lineName) {
        return getPathByLineName(lineName).containsStationName(station);

    }

    public static void deleteStationOnPathByLineName(String[] pathInfo) {
        String lineName = pathInfo[0];
        String stationName = pathInfo[1];
        getPathByLineName(lineName).deletePathByName(stationName);
    }


}
