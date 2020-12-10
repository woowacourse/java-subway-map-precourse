package subway.line.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.line.domain.Line;
import subway.station.dto.StationResponseDto;

public class LineResponseDto {

    private String name;
    private List<StationResponseDto> stations;

    public LineResponseDto(String name, List<StationResponseDto> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static LineResponseDto of(Line entity) {
        return new LineResponseDto(
            entity.getName(),
            StationResponseDto.of(entity.getStations())
        );
    }

    public static List<LineResponseDto> of(List<Line> entities) {
        return entities.stream()
            .map(LineResponseDto::of)
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
