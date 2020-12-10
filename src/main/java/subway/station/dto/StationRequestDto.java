package subway.station.dto;

public class StationRequestDto {

    private String name;

    public StationRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
