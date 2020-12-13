package subway.controller.constants;

public enum InitialThirdLine {
    ONE(0, "교대역"),
    TWO(1, "남부터미널역"),
    THREE(2, "양재역"),
    FOUR(3, "매봉역");

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
