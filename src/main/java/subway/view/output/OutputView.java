package subway.view.output;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.view.utils.Formatter;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String PRINT_STATION_HEADER = "## 역 목록";

    public static void printStationList(List<Station> list) {
        System.out.println(PRINT_STATION_HEADER);

        list.stream()
                .map(Station::getName)
                .map(StationName::toString)
                .map(Formatter::Info)
                .forEach(System.out::println);

        System.out.println();
    }
}
