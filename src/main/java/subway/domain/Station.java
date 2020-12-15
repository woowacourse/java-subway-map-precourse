package subway.domain;

public class Station {
    private StationName name;

    public Station(StationName name) {
        this.name = name;
    }

    public StationName getName() {
        return name;
    }

}
