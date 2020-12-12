package subway.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SubwayRepository {
    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();

    public static void addSubwayRealLine(String[] lineInfo) {
        Line line = new Line(lineInfo[0]);
        LineRepository.addLine(line);
        PathRepository links = new PathRepository(lineInfo[1], lineInfo[2]);
        subwayRealLines.put(line, links);
    }

    public static PathRepository getStationLinksByLine(String lineName) {
        Line line = LineRepository.findLine(lineName);
        return subwayRealLines.get(line);
    }

    public static void deleteSubwayLineByName(String lineName) {
        Line line = LineRepository.findLine(lineName);
        subwayRealLines.remove(line);
    }



}
