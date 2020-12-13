package subway.controller.constants;

public enum InitialSecondLine {
    ONE(0, "교대역"),
    TWO(1, "강남역"),
    THREE(2, "역삼역");

    private final int order;
    private final String stationName;

    private InitialSecondLine(int order, String stationName) {
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
