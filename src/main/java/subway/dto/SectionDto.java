package subway.dto;

public class SectionDto {
    private final String lineName;
    private final String stationName;
    private final String sequence;

    public SectionDto(String lineName, String stationName, String sequence) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.sequence = sequence;
    }
}
