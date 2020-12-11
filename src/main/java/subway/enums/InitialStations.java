package subway.enums;

public enum InitialStations {
    KYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    NAMBU_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAE_SIMIN_SOUP("양재시민의숲역"),
    MAEBONG("매봉역");

    private String name;

    InitialStations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
