package subway.domain.station.dto;

public class StationSaveReqDto {
    final String name;

    public StationSaveReqDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
