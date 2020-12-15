package subway.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineService {
    private static final String DUPLICATE_ERROR = "[ERROR] 이미 등록된 노선 이름입니다.\n";
    private static final String NOT_DELETE_ERROR = "[ERROR] 삭제할 수 없습니다.\n";
    private static final String OUT_OF_BOUND_ERROR = "[ERROR] 범위 밖의 순서입니다.\n";
    private static final String NOT_EXIST_ERROR = "[ERROR] 해당 노선을 찾을 수 없습니다.\n";
    private static final String STATION_COUNT_ERROR = "[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.\n";
    private static final String JUNCTION_ERROR = "[ERROR] 갈래길을 생성할 수 없습니다.\n";

    public static void register(String lineName, String upTrainLastStationName,
        String downTrainLastStationName) {
        validateDuplicate(lineName);
        Station findUpLastStation = StationService.searchOneByName(upTrainLastStationName);
        Station findDownLastStation = StationService.searchOneByName(downTrainLastStationName);
        LineRepository.addLine(new Line(lineName), findUpLastStation, findDownLastStation);
    }

    public static void delete(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            throw new IllegalArgumentException(NOT_DELETE_ERROR);
        }
    }

    public static boolean hasSameLine(String lineName) {
        Optional<Line> findLine = LineRepository.findByName(lineName);
        return findLine.isPresent();
    }

    public static Map<Line, List<Station>> searchAll() {
        return LineRepository.lines();
    }

    public static Line searchOneByName(String lineName) {
        return LineRepository.findByName(lineName)
            .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_ERROR));
    }

    public static boolean hasStationInLines(Station station) {
        return LineRepository.lines()
            .entrySet()
            .stream()
            .anyMatch(line -> line.getValue().contains(station));
    }

    public static void join(String lineName, String stationName, int sequence) {
        Map<Line, List<Station>> lines = LineRepository.lines();
        Line findLine = LineService.searchOneByName(lineName);
        Station findStation = StationService.searchOneByName(stationName);
        validateMakeJunction(lines, findLine, findStation);
        validateBound(lines, findLine, sequence);
        LineRepository.addSection(findLine, findStation, sequence);
    }

    public static void deleteStationInLine(String lineName, String stationName) {
        Map<Line, List<Station>> lines = LineRepository.lines();
        Line findLine = LineService.searchOneByName(lineName);
        Station findStation = StationService.searchOneByName(stationName);
        validateOnlyUpStreamStations(lines, findLine);
        if (!LineRepository.subtractSection(findLine, findStation)) {
            throw new IllegalArgumentException(NOT_DELETE_ERROR);
        }
    }

    private static void validateOnlyUpStreamStations(Map<Line, List<Station>> lines,
        Line findLine) {
        if (lines.get(findLine).size() <= 2) {
            throw new IllegalArgumentException(STATION_COUNT_ERROR);
        }
    }

    private static void validateDuplicate(String lineName) {
        if (hasSameLine(lineName)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private static void validateBound(Map<Line, List<Station>> lines, Line findLine, int sequence) {
        if (lines.get(findLine).size() + 1 < sequence) {
            throw new IllegalArgumentException(OUT_OF_BOUND_ERROR);
        }
    }

    private static void validateMakeJunction(Map<Line, List<Station>> lines, Line findLine,
        Station findStation) {
        if (hasSameStationInLine(lines, findLine, findStation)) {
            throw new IllegalArgumentException(JUNCTION_ERROR);
        }
    }

    private static boolean hasSameStationInLine(Map<Line, List<Station>> lines, Line findLine,
        Station findStation) {
        return lines.get(findLine).stream().anyMatch(station -> station.equals(findStation));
    }

}
