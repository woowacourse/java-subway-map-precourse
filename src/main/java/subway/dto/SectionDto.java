package subway.dto;

public class SectionDto {
    private static final int EMPTY_SECTION_ORDER_NUMBER = 0;

    private final String lineName;
    private final String stationName;
    private final int sectionOrderNumber;

    public SectionDto(String lineName, String stationName) {
        this(lineName, stationName, EMPTY_SECTION_ORDER_NUMBER);
    }

    public SectionDto(String lineName, String stationName, int sectionOrderNumber) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.sectionOrderNumber = sectionOrderNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

    public int getSectionOrderNumber() {
        return sectionOrderNumber;
    }
}
