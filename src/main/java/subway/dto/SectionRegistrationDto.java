package subway.dto;

public class SectionRegistrationDto {
    private final String lineName;
    private final String stationName;
    private final String sequence;

    public SectionRegistrationDto(String lineName, String stationName, String sequence) {
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

    public String getSequence() {
        return sequence;
    }
}
