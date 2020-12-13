package subway.dto.station;

public class StationRequestDto {

    private final String stationName;

    public StationRequestDto(String stationName) {
        this.stationName = stationName;
    }

    public String getName() {
        return stationName;
    }
}
