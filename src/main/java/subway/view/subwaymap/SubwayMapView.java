package subway.view.subwaymap;

import subway.line.EachLineStations;
import subway.station.Station;

public class SubwayMapView {
    private static final String RESULT_PREFIX = "[INFO] ";
    private static final String DIVIDER = RESULT_PREFIX + "---";

    public static void showLineInformation(String lineName, EachLineStations stations) {
        System.out.println(RESULT_PREFIX + lineName);
        System.out.println(DIVIDER);
        for (Station station : stations.getStations()) {
            System.out.println(RESULT_PREFIX + station.getName());
        }
        System.out.println();
    }
}
