package subway.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {
    private static final String DUPLICATE_ERROR = "[ERROR] 이미 등록된 노선 이름입니다.\n";
    private static final String NOT_DELETE_ERROR = "[ERROR] 삭제할 수 없습니다.\n";
    private static final String NOT_EXIST_ERROR = "[ERROR] 등록할 수 없습니다.\n";
    private static final String OUT_OF_BOUND_ERROR = "[ERROR] 범위 밖의 순서입니다.\n";
    private static final String STATION_COUNT_ERROR = "[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.\n";

    public static void register(String lineName, String upTrainLastStationName
        , String downTrainLastStationName) {
        validateDuplicate(lineName);
        validateStationExistence(upTrainLastStationName);
        validateStationExistence(downTrainLastStationName);
        LineRepository.addLine(new Line(lineName), new Station(upTrainLastStationName)
            , new Station(downTrainLastStationName));
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

    public static Map<Line, List<Station>> search() {
        return LineRepository.lines();
    }

    public static void join(String lineName, String stationName, int sequence) {
        validateLineExistence(lineName);
        validateStationExistence(stationName);
        Map<Line, List<Station>> lines = LineRepository.lines();
        Line findLine = LineRepository.findByName(lineName).get();
        Station findStation = StationRepository.findByName(stationName).get();
        validateBound(sequence, findLine, lines);
        LineRepository.addSection(findLine, findStation, sequence);
    }

    public static void deleteStationInLine(String lineName, String stationName) {
        Map<Line, List<Station>> lines = LineRepository.lines();
        Line findLine = LineRepository.findByName(lineName).get();
        Station findStation = StationRepository.findByName(stationName).get();
        if (lines.get(findLine).size() <= 2) {
            throw new IllegalArgumentException(STATION_COUNT_ERROR);
        }
        if (!LineRepository.subtractSection(findLine, findStation)) {
            throw new IllegalArgumentException(NOT_DELETE_ERROR);
        }
    }

    private static void validateStationExistence(String stationName) {
        if (!StationService.hasSameStation(stationName)) {
            throw new IllegalArgumentException(NOT_EXIST_ERROR);
        }
    }

    private static void validateDuplicate(String lineName) {
        if (hasSameLine(lineName)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private static void validateLineExistence(String lineName) {
        if (!hasSameLine(lineName)) {
            throw new IllegalArgumentException(NOT_EXIST_ERROR);
        }
    }

    private static void validateBound(int sequence, Line findLine,
        Map<Line, List<Station>> lines) {
        if (lines.get(findLine).size() < sequence || lines.get(findLine).size() - 1 > sequence) {
            throw new IllegalArgumentException(OUT_OF_BOUND_ERROR);
        }
    }
}
