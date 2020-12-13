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

    public static void printLine(String output) {
        System.out.println(output);
    }

    public static void printStations(List<Station> stations) {
        if (!stations.isEmpty()) {
            Message.printStations();
            stations.stream().map(Station::getName).forEach(Message::printStation);
        }
    }
}
