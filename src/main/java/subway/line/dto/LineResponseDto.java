package subway.line.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.line.domain.Line;

public class LineResponseDto {

    private final String name;
    private final List<LineStationResponseDto> lineStations;

    public LineResponseDto(String name, List<LineStationResponseDto> lineStations) {
        this.name = name;
        this.lineStations = lineStations;
    }

    public static LineResponseDto of(Line entity) {
        return new LineResponseDto(
            entity.getName(),
            LineStationResponseDto.of(entity.getLineStations())
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

    public List<LineStationResponseDto> getLineStations() {
        return lineStations;
    }
}
