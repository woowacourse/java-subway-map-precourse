package subway.view.subwaymap;

import subway.common.Prefix;
import subway.line.EachLineStations;
import subway.station.Station;

public class SubwayMapView {
    private static final String DIVIDER = Prefix.INFO.getPrefix() + "---";

    public static void showLineInformation(String lineName, EachLineStations stations) {
        System.out.println(Prefix.INFO.getPrefix() + lineName);
        System.out.println(DIVIDER);
        for (Station station : stations.getStations()) {
            System.out.println(Prefix.INFO.getPrefix() + station.getName());
        }
        System.out.println();
    }
}
