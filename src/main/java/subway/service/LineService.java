package subway.service;

import subway.domain.LineRepository;

public class LineService {

    public static boolean contain(String name) {
        return LineRepository.lines().stream()
            .anyMatch(line -> line.getStations().stream()
            .anyMatch(station -> station.getName().equals(name)));
    }
}
