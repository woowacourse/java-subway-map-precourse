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

    public void deleteStation(Line line, Station target) {
        List<Station> stations = route.get(line);
        Station station = findByName(stations, target.getName());
        stations.remove(station);
    }

    private Station findByName(List<Station> stations, String target) {
        return stations.stream()
                .filter(station -> station.getName().equals(target))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.STATION_NOT_FOUND_ERROR));
    }
}
