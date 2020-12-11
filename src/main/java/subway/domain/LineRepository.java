package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public LineRepository() {
        init();
    }

    private void init() {
        Line line2 = new Line("2호선", "교대역", "역삼역");
        line2.add(1, "강남역");
        lines.add(line2);

        Line line3 = new Line("3호선", "교대역", "매봉역");
        line3.add(1, "양재역");
        line3.add(1, "남부터미널역");
        lines.add(line3);

        Line bundangLine = new Line("신분당선", "강남역", "양재시민의숲역");
        bundangLine.add(1, "양재역");
        lines.add(bundangLine);
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
