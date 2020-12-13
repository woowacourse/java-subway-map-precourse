package subway.setup;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.repository.LineRepository;

/**
 * @author yhh1056
 * @since 2020/12/12
 */
public class SetLine {
    private static final String TWO_LINE = "2호선";
    private static final String THREE_LINE = "3호선";
    private static final String SINBUNDANG_LINE = "신분당선";

    static final Line twoLine = new Line(TWO_LINE);
    static final Line threeLine = new Line(THREE_LINE);
    static final Line sinbundangLine = new Line(SINBUNDANG_LINE);

    private SetLine() {
    }

    private static final List<Line> setUpLines = Arrays.asList(
            twoLine, threeLine, sinbundangLine);

    static void setUpLines() {
        setUpLines.forEach(LineRepository::addLine);
    }
}
