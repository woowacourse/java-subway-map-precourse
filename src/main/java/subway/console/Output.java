package subway.console;

import static java.lang.System.out;
import static subway.console.message.ErrorMessage.EMPTY_LINE;

import java.util.List;
import java.util.Map;
import subway.console.message.InfoMessage;
import subway.domain.Line;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class Output {

    private Output() {
    }

    public static void printPage(final List<String> page) {
        page.forEach(out::println);
    }

    public static void printStations(List<Station> stations) {
        if (!stations.isEmpty()) {
            print(InfoMessage.STATIONS);
            stations.forEach(station -> print(combine(station.getName())));
        }
    }

    public static void printLines(List<Line> lines) {
        if (!lines.isEmpty()) {
            print(InfoMessage.LINES);
            lines.forEach(line -> print(combine(line.getName())));
        }
    }

    public static void printSubwayLine(Map<Line, List<Station>> sections) {
        if (isEmpty(sections)) {
            print(EMPTY_LINE.getMessage());
            return;
        }

        print(InfoMessage.SUBWAY_LINE);
        printSubwayInformation(sections);
    }

    private static void printSubwayInformation(Map<Line, List<Station>> sections) {
        for (Line line : sections.keySet()) {
            print(combine(line.getName()));
            print(InfoMessage.SUBWAY_INFO);

            sections.get(line).forEach(station -> print(combine(station.getName())));
            printBlankLine();
        }
    }

    private static String combine(String name) {
        return InfoMessage.INFO + name;
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
