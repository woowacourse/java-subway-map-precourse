package subway.domain.section.dto;

public class SectionStationDeleteReqDto {
    private String lineName;
    private String stationName;

    public SectionStationDeleteReqDto(String lineName, String stationName) {
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
