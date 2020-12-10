package subway.station;

import subway.domain.Station;

public class StationDTO {
    private String name;

    public StationDTO(Station station) {
        this.name = station.getName();
    }

    public String getName() {
        return name;
    }
}
