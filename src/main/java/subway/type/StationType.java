package subway.type;

/**
 * StationType.java : 지하철 역 초기화용 상수를 모아둔 Enum 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public enum  StationType {
    EDUCATION_UNIVERSITY("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_BUS_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAE_CITIZENS_FOREST("양재시민의숲역"),
    MAEBONG("매봉역");

    private final String station;

    StationType(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
