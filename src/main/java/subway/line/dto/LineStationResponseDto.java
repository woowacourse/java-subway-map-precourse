package subway.line.dto;

import java.util.List;
import java.util.stream.Collectors;
import subway.line.domain.LineStation;

public class LineStationResponseDto {

    private final String stationName;
    private final String prevStationName;

    public LineStationResponseDto(String stationName, String prevStationName) {
        this.stationName = stationName;
        this.prevStationName = prevStationName;
    }

    public static LineStationResponseDto of(LineStation entity) {
        String stationName = null;
        if (!entity.isFirst()) {
            stationName = entity.getPrevStation().getName();
        }

        return new LineStationResponseDto(
            entity.getStation().getName(), stationName);
    }

    public static List<LineStationResponseDto> of(List<LineStation> entities) {
        return entities.stream()
            .map(LineStationResponseDto::of)
            .collect(Collectors.toList());
    }

    public String getStationName() {
        return stationName;
    }

    public String getPrevStationName() {
        return prevStationName;
    }
}
