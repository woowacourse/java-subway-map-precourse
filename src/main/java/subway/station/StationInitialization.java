package subway.station;

import utils.StringSeparation;

import java.util.Arrays;
import java.util.List;

public class StationInitialization {
    private static final String basicStationsName = "교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역";
    private static final List<String> basicStations = Arrays.asList(StringSeparation.stringToArray(basicStationsName));

    public static void setBasicStations() {
        for (String name : basicStations) {
            Station station = new Station(name);
            StationService.addStation(station);
        }
    }
}
