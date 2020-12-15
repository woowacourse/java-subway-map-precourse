package subway.dto;

import subway.domain.station.Station;

public class StationDto {
    private final String name;

    public StationDto(String name) {
        this.name = name;
    }

    public Station toStation() {
        return new Station(name);
    }
}
