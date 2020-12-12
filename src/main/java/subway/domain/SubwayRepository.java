package subway.domain;

import java.util.HashMap;
import java.util.Map;

public class SubwayRepository {

    private static final Map<Line, LinkRepository> subwayRealLines = new HashMap<>();

    public static void addSubwayRealLine(String[] lineInfo){
        Line line = new Line(lineInfo[0]);
        LineRepository.addLine(line);
        LinkRepository links = new LinkRepository(lineInfo[1],lineInfo[2]);
        subwayRealLines.put(line, links);
    }

    public static LinkRepository getStationLinksByLine(Line line){
        return subwayRealLines.get(line);
    }

}
