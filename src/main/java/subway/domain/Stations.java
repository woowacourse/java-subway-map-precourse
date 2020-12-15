package subway.domain;

/**
 * Stations.java : 지하철 상행 종점역, 하행 종점역에 대한 도메인 모델 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class Stations {
    private final String upStationName;
    private final String downStationName;

    public Stations(String upStationName, String downStationName) {
        this.upStationName = upStationName;
        this.downStationName = downStationName;
    }

    public String getUpStationName() {
        return upStationName;
    }

    public String getDownStationName() {
        return downStationName;
    }
}
