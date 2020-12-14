package subway.controller.constants;

public enum InitialStations {
    ONE("교대역"),
    TWO("강남역"),
    THREE("역삼역"),
    FOUR("남부터미널역"),
    FIVE("양재역"),
    SIX("양재시민의숲역"),
    SEVEN("매봉역");

    private final String stationName;

    InitialStations(String stationName) {
        this.stationName = stationName;
    }

    public String getName() {
        return stationName;
    }
}
