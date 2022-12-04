package subway.initialization;

import subway.domain.Station;

public enum InitStation {
    KYODAE(new Station("교대역")),
    GANGNAM(new Station("강남역")),
    YEOKSAM(new Station("역삼역")),
    NAMBU_TERMINAL(new Station("남부터미널역")),
    YANGJAE(new Station("양재역")),
    YANGJAE_FOREST(new Station("양재시민의숲역")),
    MAEBONG(new Station("매봉역"));

    private final Station stationName;

    InitStation(Station stationName) {
        this.stationName = stationName;
    }

    public Station getStationName() {
        return stationName;
    }

    @Override
    public String toString() {
        return stationName.getName();
    }
}

