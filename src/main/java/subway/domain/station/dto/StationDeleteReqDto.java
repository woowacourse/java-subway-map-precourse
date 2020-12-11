package subway.domain.station.dto;

public class StationDeleteReqDto {
    private String name;

    public StationDeleteReqDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
