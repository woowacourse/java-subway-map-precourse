package subway.line.dto;

public class SectionInsertRequestDto {

    private final String lineName;
    private final int indexToInsert;
    private final String stationName;

    public SectionInsertRequestDto(String lineName, int indexToInsert, String stationName) {
        this.lineName = lineName;
        this.indexToInsert = indexToInsert;
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public int getIndexToInsert() {
        return indexToInsert;
    }

    public String getStationName() {
        return stationName;
    }
}
