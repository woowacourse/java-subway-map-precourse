package subway.domain;

import java.util.HashMap;
import java.util.Map;

public class SubwayRepository {

    private static final Map<Line, PathRepository> subwayRealLines = new HashMap<>();

    public static void addSubwayRealLine(String[] lineInfo){
        Line line = new Line(lineInfo[0]);
        LineRepository.addLine(line);
        PathRepository links = new PathRepository(lineInfo[1],lineInfo[2]);
        subwayRealLines.put(line, links);
    }

    public static PathRepository getStationLinksByLine(Line line){
        return subwayRealLines.get(line);
    }

}
