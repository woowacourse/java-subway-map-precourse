package subway.dto;

public class LineDto {
    private final String lineName;
    private final String upwardLastStationName;
    private final String downwardLastStationName;

    public LineDto(String lineName, String upwardLastStationName, String downwardLastStationName) {
        this.lineName = lineName;
        this.upwardLastStationName = upwardLastStationName;
        this.downwardLastStationName = downwardLastStationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getUpwardLastStationName() {
        return upwardLastStationName;
    }

    public String getDownwardLastStationName() {
        return downwardLastStationName;
    }
}
