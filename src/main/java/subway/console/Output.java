package subway.console;

import static java.lang.System.out;
import static subway.console.message.ErrorMessage.EMPTY_LINE;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class Output {
    public static final String STATIONS = "\n## 역목록";
    public static final String LINES = "\n## 노선목록";
    public static final String SUBWAY_LINE = "\n## 지하철 노선도";
    public static final String INFO = "[INFO] ";
    public static final String SUBWAY_INFO = "[INFO] ---";

    private Output() {
    }

    public static void printPage(final List<String> page) {
        page.forEach(out::println);
    }

    public static void printStations(List<Station> stations) {
        if (!stations.isEmpty()) {
            print(STATIONS);
            stations.forEach(station -> print(combine(station.getName())));
        }
    }

    public static void printLines(List<Line> lines) {
        if (!lines.isEmpty()) {
            print(LINES);
            lines.forEach(line -> print(combine(line.getName())));
        }
    }

    public static void printSubwayLine(Map<Line, List<Station>> sections) {
        if (isEmpty(sections)) {
            print(EMPTY_LINE.getMessage());
            return;
        }

        print(SUBWAY_LINE);
        printSubwayInformation(sections);
    }

    private static void printSubwayInformation(Map<Line, List<Station>> sections) {
        for (Line line : sections.keySet()) {
            print(combine(line.getName()));
            print(SUBWAY_INFO);

            sections.get(line).forEach(station -> print(combine(station.getName())));
            printBlankLine();
        }
    }

    private static String combine(String name) {
        return INFO + name;
    }

    private static boolean isEmpty(Map<Line, List<Station>> sections) {
        return sections.isEmpty();
    }

    public static void print(String message) {
        out.println(message);
    }

    public static void printBlankLine() {
        out.println();
    }
}
