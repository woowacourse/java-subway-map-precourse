package subway.domain.section.dto;

public class SectionSaveReqDto {
    private String lineName;
    private String upwardStationName;
    private String downwardStationName;

    public SectionSaveReqDto(String lineName, String upwardStationName, String downwardStationName) {
        this.lineName = lineName;
        this.upwardStationName = upwardStationName;
        this.downwardStationName = downwardStationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getUpwardStationName() {
        return upwardStationName;
    }

    public String getDownwardStationName() {
        return downwardStationName;
    }
}
