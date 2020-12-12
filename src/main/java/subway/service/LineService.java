package subway.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import subway.controller.StationController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {
    private static final String DUPLICATE_ERROR = "[ERROR] 이미 등록된 노선 이름입니다.\n";
    private static final String NOT_DELETE_ERROR = "[ERROR] 삭제할 수 없습니다.\n";
    private static final String NOT_EXIST_ERROR = "[ERROR] 등록할 수 없습니다.\n";
    private static final String OUT_OF_BOUND_ERROR = "[ERROR] 범위 밖의 순서입니다.\n";

    public static void register(String lineName, String upTrainLastStationName
        , String downTrainLastStationName) {
        validateDuplicate(lineName);
        validateStationExistence(upTrainLastStationName, downTrainLastStationName);
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
        validateExistence(lineName, stationName);
        Line findLine = LineRepository.findByName(lineName).get();
        Map<Line, List<Station>> lines = LineRepository.lines();
        Optional<Station> findStation = StationRepository.findByName(stationName);
        validateBound(sequence, findLine, lines);
        LineRepository.addSection(findLine, findStation.get(), sequence);
    }

    private static void validateStationExistence(String upTrainLastStationName
        , String downTrainLastStationName) {
        if (!StationService.hasSameStation(upTrainLastStationName)
            && !StationService.hasSameStation(downTrainLastStationName)) {
            throw new IllegalArgumentException(NOT_EXIST_ERROR);
        }
    }

    private static void validateDuplicate(String lineName) {
        if (hasSameLine(lineName)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private static void validateExistence(String lineName, String stationName) {
        if (!hasSameLine(lineName) || !StationService.hasSameStation(stationName)) {
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
