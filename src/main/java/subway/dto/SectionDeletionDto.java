package subway.dto;

public class SectionDeletionDto {
    private final String lineName;
    private final String stationName;

    public SectionDeletionDto(String lineName, String stationName) {
        this.lineName = lineName;
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }
}
