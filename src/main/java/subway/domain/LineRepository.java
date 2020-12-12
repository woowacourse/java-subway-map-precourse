package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    public static final String LINE_TWO = "2호선";
    public static final String LINE_THREE = "3호선";
    public static final String LINE_SINBUNDANG = "신분당선";
    public static final String GYODAE_STAION = "교대역";
    public static final String GANGNAM_STAION = "강남역";
    public static final String YEOKSAM_STAION = "역삼역";
    public static final String NAMBUBUS_STAION = "남부터미널역";
    public static final String YANGJAE_STAION = "양재역";
    public static final String YANGJAE_CITIZENS_FOREST_STAION = "양재시민의숲역";
    public static final String MAEBONG_STAION = "매봉역";
    private static final List<Line> lines = new ArrayList<>();
    private static final List<Line> defaultLines = new ArrayList<>();

    public LineRepository() {
        initDefaultLines();
        for (Line line : defaultLines) {
            lines.add(line);
        }
    }

    public static void initDefaultLines() {
        Line lineTwo = new Line(LINE_TWO).addStation(new Station(GANGNAM_STAION))
            .addStation(new Station(GANGNAM_STAION)).addStation(new Station(YEOKSAM_STAION));
        Line lineThree = new Line(LINE_THREE).addStation(new Station(GYODAE_STAION))
            .addStation(new Station(NAMBUBUS_STAION)).addStation(new Station(YANGJAE_STAION))
            .addStation(new Station(MAEBONG_STAION));
        Line lineSinbundang = new Line(LINE_SINBUNDANG).addStation(new Station(GANGNAM_STAION))
            .addStation(new Station(YANGJAE_STAION))
            .addStation(new Station(YANGJAE_CITIZENS_FOREST_STAION));
        defaultLines.add(lineTwo);
        defaultLines.add(lineThree);
        defaultLines.add(lineSinbundang);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
