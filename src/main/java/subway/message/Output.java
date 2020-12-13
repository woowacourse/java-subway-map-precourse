package subway.message;

import java.util.List;
import subway.domain.Station;

/**
 * @author yhh1056
 * @since 2020/12/13
 */
public class Output {

    private Output() {
    }

    public static void printPage(final List<String> page) {
        page.forEach(System.out::println);
    }

    public static void printStations(List<Station> stations) {
        if (!stations.isEmpty()) {
            printLine(Message.STATIONS);
            stations.forEach(station -> printLine(combineName(station)));
        }
    }

    private static String combineName(Station station) {
        return Message.INFO + station.getName();
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static void printBlankLine() {
        System.out.println();
    }
}
