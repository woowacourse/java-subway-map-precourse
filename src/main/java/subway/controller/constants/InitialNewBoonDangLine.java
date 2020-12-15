package subway.controller.constants;

public enum InitialNewBoonDangLine {
    ONE(1, "강남역"),
    TWO(2, "양재역"),
    THREE(3, "양재시민의숲역");

    private final int order;
    private final String stationName;

    private InitialNewBoonDangLine(int order, String stationName) {
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
