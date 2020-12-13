package subway.domain.section.dto;

public class SectionStationAddReqDto {
    private String lineName;
    private String stationName;
    private int sequence;

    public SectionStationAddReqDto(String lineName, String stationName, int sequence) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.sequence = sequence;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

    public int getSequence() {
        return sequence;
    }
}
