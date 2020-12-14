package subway.domain;

import java.util.HashMap;
import java.util.Map;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.path.PathRepository;

public class SubwayRepository {
    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();

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
        Line line = LineRepository.findLineByName(lineName);
        return subwayRealLines.get(line);
    }

    public static void addPathByLineNameAndIndex(String[] pathInfo) {
        String lineName = pathInfo[0];
        String station = pathInfo[1];
        int index = Integer.parseInt(pathInfo[2])-1;
        Line line = LineRepository.findLineByName(lineName);
        PathRepository pathRepository = subwayRealLines.get(line);
        pathRepository.addPath(index, station);
    }

    public static void deleteSubwayLineByName(String lineName) {
        Line line = LineRepository.findLineByName(lineName);
        subwayRealLines.remove(line);
    }

    public static int getSizeOfPathByLineName(String lineName) {
        return getPathByLineName(lineName).pathSize();
    }

    public static boolean containsStationOnLine(String station, String lineName) {
        return getPathByLineName(lineName).containsStationByName(station);

    }

    public static boolean checkStationOnPath(String stationName){
        for(PathRepository path: subwayRealLines.values()){
            if(path.checkStationOnPathByName(stationName)){
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


}
