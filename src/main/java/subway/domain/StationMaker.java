package subway.domain;

public class StationMaker {

    public static Station make(String stationName) {
        return new Station(stationName);
    }
}
