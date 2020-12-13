package subway.domain.station;

public class Station {
    private String name;
    public static final int MIN_NAME_SIZE = 2;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Station getStation(String stationName) {
        if (StationCheck.checkStationNameLength(stationName) && StationCheck.checkStationNameEndPoint(stationName)) {
        }
        return new Station(stationName);
    }
}
