package subway.domain.section;

public class Section {
    private String lineName;
    private String stationName;
    private int order;

    public Section(String lineName, String stationName, int order) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.order = order;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

    public int getOrder() {
        return order;
    }
}
