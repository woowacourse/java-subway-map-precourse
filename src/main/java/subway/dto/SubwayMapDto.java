package subway.dto;

import subway.domain.entity.Line;

import java.util.List;

public class SubwayMapDto {

    private final String lineName;
    private final List<String> stationNames;

    private SubwayMapDto(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public static SubwayMapDto from(Line line) {
        return new SubwayMapDto(line.getName(), line.getStationNames());
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
