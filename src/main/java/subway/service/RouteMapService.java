package subway.service;

import subway.domain.line.Line;
import subway.repository.line.LineRepository;
import subway.view.util.Formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RouteMapService {
    private static final String DOTS = "---";

    private final LineRepository lineRepository;

    public RouteMapService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public String get() {
        return toRouteMap();
    }

    private String toRouteMap() {
        List<String> routeMap = lineRepository.lines().stream().map(line -> {
            List<String> lineMap = new ArrayList<>();

            lineMap.add(Formatter.Info(line.getName().toString()));
            lineMap.add(Formatter.Info(DOTS));
            lineMap.addAll(line.sections().stream()
                    .map(station -> Formatter.Info(station.getName().toString()))
                    .collect(Collectors.toList()));

            return String.join(System.lineSeparator(), lineMap);
        }).collect(Collectors.toList());

        return String.join(System.lineSeparator(), routeMap);
    }
}
