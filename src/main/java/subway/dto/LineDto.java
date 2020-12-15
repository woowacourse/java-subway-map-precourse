package subway.dto;

public class LineDto {
    private final String name;
    private final String upwardEndStationName;
    private final String downwardEndStationName;

    public LineDto(String name, String upwardEndStationName, String downwardEndStationName) {
        this.name = name;
        this.upwardEndStationName = upwardEndStationName;
        this.downwardEndStationName = downwardEndStationName;
    }

    public String getName() {
        return name;
    }

    public String getUpwardEndStationName() {
        return upwardEndStationName;
    }

    public String getDownwardEndStationName() {
        return downwardEndStationName;
    }
}
