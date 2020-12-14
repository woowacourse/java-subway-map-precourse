package subway.line;

import subway.domain.Line;
import subway.station.StationResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LineResponseDTO {
    private String name;
    private List<StationResponseDTO> stations;

    public LineResponseDTO(Line line) {
        name = line.getName();
        stations = line.stations()
                .stream()
                .map(StationResponseDTO::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public List<StationResponseDTO> getStations() {
        return stations;
    }
}
