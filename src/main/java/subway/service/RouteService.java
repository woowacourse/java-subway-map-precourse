package subway.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Route;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.global.exception.CustomException;
import subway.global.exception.ErrorMessage;

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

    public void addRoute(String lineName, String headName, String tailName) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.LINE_NOT_FOUND_ERROR));
        Station head = stationRepository.findByName(headName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.STATION_NOT_FOUND_ERROR));
        Station tail = stationRepository.findByName(tailName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.STATION_NOT_FOUND_ERROR));
        route.add(line, List.of(head, tail));
    }

    public void addStation(String lineName, String stationName, int index) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.LINE_NOT_FOUND_ERROR));
        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.STATION_NOT_FOUND_ERROR));
        route.addStation(line, station, index);
    }

    public void deleteStation(String lineName, String stationName) {
        Line line = lineRepository.findByName(lineName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.LINE_NOT_FOUND_ERROR));
        Station station = stationRepository.findByName(stationName)
                .orElseThrow(() -> CustomException.from(ErrorMessage.STATION_NOT_FOUND_ERROR));
        route.deleteStation(line, station);
    }
}
