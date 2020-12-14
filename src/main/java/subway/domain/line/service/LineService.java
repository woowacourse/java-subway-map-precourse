package subway.domain.line.service;

import subway.domain.line.model.Line;
import subway.domain.line.model.LineRepository;
import subway.domain.station.model.Station;
import subway.domain.station.model.StationRepository;

import java.util.List;

public class LineService {
    private static final String ALREADY_CONTAIN_STATION_MESSAGE = "[ERROR] 이미 노선에 포함되어 역입니다.";
    private static final String NOT_DUPLICATION_LINE_NAME_MESSAGE = "[ERROR] 중복된 노선 이름은 등록할 수 없습니다.";
    private static final String NOT_FOUND_STATION_MESSAGE = "[ERROR] 존재하지 않는 역입니다.";
    private static final String NOT_FOUND_Line_MESSAGE = "[ERROR] 존재하지 않는 노선입니다.";

    public static List<Line> findAll() {
        return LineRepository.lines();
    }

    public static void save(Line line) {
        validateLine(line);
        LineRepository.addLine(line);
    }

    private static void validateLine(Line line) {
        validateDuplicationLine(line);
        validateStations(line);
    }

    private static void validateStations(Line line) {
        List<Station> stations = line.getStations();
        stations.stream()
                .forEach(LineService::validateStation);
    }

    private static void validateStation(Station station) {
        List<Station> registeredStations = StationRepository.stations();
        registeredStations.stream()
                .filter(registeredStation -> registeredStation.isEqualTo(station.getName()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_STATION_MESSAGE));
    }

    private static void validateDuplicationLine(Line line) {
        List<Line> lines = LineRepository.lines();
        boolean isDuplicated = lines.stream()
                .anyMatch(savedLine -> savedLine.isEqualTo(line.getName()));

        if (isDuplicated) {
            throw new IllegalArgumentException(NOT_DUPLICATION_LINE_NAME_MESSAGE);
        }
    }

    public static void remove(String removedLineName) {
        LineRepository.deleteLineByName(removedLineName);
    }

    public static void addStation(String lineName, String stationName, int location) {
        Line line = LineRepository.findLineByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_Line_MESSAGE));

        validateSectionDuplicated(stationName, line);
        Station station = new Station(stationName);
        validateStation(station);
        line.addStation(location, station);
    }

    private static void validateSectionDuplicated(String stationName, Line line) {
        boolean contains = line.getStations().stream()
                .anyMatch(station -> station.isEqualTo(stationName));

        if (contains) {
            throw new IllegalArgumentException(ALREADY_CONTAIN_STATION_MESSAGE);
        }
    }

    public static Line findLineByName(String lineName) {
        return LineRepository.findLineByName(lineName)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_Line_MESSAGE));
    }
}
