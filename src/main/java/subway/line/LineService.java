package subway.line;

import subway.line.domain.Line;
import subway.line.domain.LineRepository;
import subway.line.domain.Route;
import subway.station.domain.Station;
import subway.station.domain.StationRepository;

public class LineService {

    public static void register(String lineName, String topStationName, String bottomStationName) {
        Station topStation = StationRepository.findByName(topStationName);
        Station bottomStation = StationRepository.findByName(bottomStationName);
        Line line = new Line(lineName, new Route(topStation, bottomStation));
        LineRepository.register(line);
    }

    public static void remove(String name) {
        Line line = LineRepository.findByName(name);
        LineRepository.remove(line);
    }
}
