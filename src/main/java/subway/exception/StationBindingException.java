package subway.exception;

import subway.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class StationBindingException extends SubwayException {

    private final String stationName;
    private final List<Line> bindings;

    public StationBindingException(String stationName, List<Line> bindings) {
        this.bindings = bindings;
        this.stationName = stationName;
    }

    @Override
    public String getMessage() {
        String bindLines = bindings.stream().map(Line::getName).collect(Collectors.joining(","));
        return ERROR + " " + stationName + "은 " + bindLines + "에 귀속되어 있습니다.";
    }
}
