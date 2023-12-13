package subway.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

public class Route {
    private Map<Line, List<Station>> route;

    public Route() {
        this.route = new HashMap<>();
    }

    public void add(Line line, List<Station> stations) {
        route.put(line, stations);
    }

    public void addStation(Line line, Station station, int index) {
        if (route.get(line).isEmpty()) {
            throw CustomException.from(ErrorMessage.LINE_NOT_FOUND_ERROR);
        }
        route.get(line).set(index, station);
    }
}
