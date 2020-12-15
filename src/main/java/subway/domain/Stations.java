package subway.domain;

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
