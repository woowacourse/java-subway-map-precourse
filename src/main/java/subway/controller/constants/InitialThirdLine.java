package subway.controller.constants;

public enum InitialThirdLine {
    ONE(1, "교대역"),
    TWO(2, "남부터미널역"),
    THREE(3, "양재역"),
    FOUR(4, "매봉역");

    private final int order;
    private final String stationName;

    private InitialThirdLine(int order, String stationName) {
        this.order = order;
        this.stationName = stationName;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return stationName;
    }
}
