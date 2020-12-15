package subway.domain;

/**
 * Section.java : 지하철 구간에 대한 도메인 모델 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class Section {
    private final String lineName;
    private final String stationName;
    private final String order;

    public Section(String lineName, String stationName, String order) {
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

    public String getOrder() {
        return order;
    }
}
