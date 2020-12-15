package subway.controller.constants;

public enum InitialSecondLine {
    ONE(1, "교대역"),
    TWO(2, "강남역"),
    THREE(3, "역삼역");

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
