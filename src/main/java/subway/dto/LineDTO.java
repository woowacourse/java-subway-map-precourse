package subway.dto;

import java.util.Collections;
import java.util.List;

public class LineDTO implements DTO {
    private final String name;
    private final List<StationDTO> stations;

    public LineDTO(String name, List<StationDTO> stations) {
        this.name = name;
        this.stations = Collections.unmodifiableList(stations);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<StationDTO> getStations() {
        return stations;
    }

}
