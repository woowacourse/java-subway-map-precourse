package subway.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.SchemaOutputResolver;

public class SubwayRepository {
    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();

    public static Map<Line,PathRepository> getSubwayRealLines(){
        return Collections.unmodifiableMap(subwayRealLines);
    }

    public static void createSubwayRealLine(String[] lineInfo) {
        Line newline = new Line(lineInfo[0]);
        LineRepository.addLine(newline);
        PathRepository path = new PathRepository(lineInfo[1], lineInfo[2]);
        subwayRealLines.put(newline, path);
    }

    public static PathRepository getPathByLineName(String lineName) {
        Line line = LineRepository.findLine(lineName);
        return subwayRealLines.get(line);
    }
    public static void addPathByLineName(String lineName, int index, String station){
        Line line = LineRepository.findLine(lineName);
        PathRepository pathRepository = subwayRealLines.get(line);
        pathRepository.addPath(index,station);
    }

    public static void deleteSubwayLineByName(String lineName) {
        Line line = LineRepository.findLine(lineName);
        subwayRealLines.remove(line);
    }

    public static int getSizeOfPathByLineName(String lineName){
        return getPathByLineName(lineName).pathSize();
    }
    public static boolean containsStationOnPathByLineName(String station, String lineName){
        return getPathByLineName(lineName).containsStationName(station);

    }


}
