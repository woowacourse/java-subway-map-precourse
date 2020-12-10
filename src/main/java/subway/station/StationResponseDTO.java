package subway.station;

import subway.domain.Station;

public class StationResponseDTO {
    private String name;

    public StationResponseDTO(Station station) {
        this.name = station.getName();
    }

    public String getName() {
        return name;
    }
}
