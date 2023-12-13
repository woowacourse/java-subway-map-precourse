package subway.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Route;
import subway.domain.Station;
import subway.domain.StationRepository;

public class RouteService {
    private final Route route;
    private final LineRepository lineRepository;
    private final StationRepository stationRepository;

    public RouteService(
            Route route,
            LineRepository lineRepository,
            StationRepository stationRepository
    ) {
        this.route = route;
        this.lineRepository = lineRepository;
        this.stationRepository = stationRepository;
    }

    public void addAll(Map<String, List<String>> elements) {
        for (Map.Entry<String, List<String>> entry : elements.entrySet()) {
            String line = entry.getKey();
            List<String> stations = entry.getValue();
            route.add(new Line(line), convertStations(stations));
        }
    }

    private List<Station> convertStations(List<String> stations) {
        return stations.stream()
                .map(Station::new)
                .collect(Collectors.toList());
    }
}
