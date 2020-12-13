package subway.dto.station;

import subway.domain.station.Station;

import java.util.List;
import java.util.stream.Collectors;

public class StationResponseDto {

    private final String name;

    public StationResponseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static StationResponseDto StationEntity(Station entity) {
        return new StationResponseDto(entity.getName());
    }

    public static List<StationResponseDto> StationEntityToList(List<Station> entities) {
        return entities.stream()
                .map(StationResponseDto::StationEntity)
                .collect(Collectors.toList());
    }
}
