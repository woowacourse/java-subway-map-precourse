package subway.station.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.station.domain.Station;

public class StationResponseDto {

    private final String name;

    public StationResponseDto(String name) {
        this.name = name;
    }

    public static StationResponseDto of(Station entity) {
        return new StationResponseDto(entity.getName());
    }

    public static List<StationResponseDto> of(List<Station> entities) {
        return entities.stream()
            .map(StationResponseDto::of)
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
