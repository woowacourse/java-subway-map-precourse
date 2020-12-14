package subway.line;

import subway.model.ResultDto;
import subway.station.Station;
import subway.station.StationService;
import subway.utils.ErrorUtils;

import java.util.List;

public class LineService {

    private static final String REGISTER_RESULT_OK_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_RESULT_OK_MESSAGE = "지하철 노선이 삭제되었습니다.";
    private static final String TWO_STATIONS_SAME_ERROR_MESSAGE = "상행 종점과 하행 종점은 같을 수 없습니다.";
    private static final String ALREADY_EXISTS_ON_LINE_STATION_ERROR_MESSAGE = "노선에 등록된 역입니다.";
    private static final String ALREADY_EXISTS_ERROR_MESSAGE = "해당 노선에 이미 존재하는 역이 있습니다.";
    private static final LineRepository repository = new LineRepository();

    private LineService() {}

    public static ResultDto registerLine(String lineName, String upEndStation, String downEndStation) {
        return ErrorUtils.produceResponse(() -> {
            checkDulicateLine(lineName);
            checkEndStations(upEndStation, downEndStation);
            repository.addLine(Line.of(lineName, upEndStation, downEndStation));
            return ResultDto.ok(REGISTER_RESULT_OK_MESSAGE);
        });
    }

    private static void checkDulicateLine(String lineName) {
        repository.checkDuplicateLine(lineName);
    }

    private static void checkEndStations(String upEndStation, String downEndStation) {
        checkUpEndStationNotEqualsToDownEndStation(upEndStation, downEndStation);
        StationService.checkExistStation(upEndStation);
        StationService.checkExistStation(downEndStation);
    }

    private static void checkUpEndStationNotEqualsToDownEndStation(String upEndStation, String downEndStation) {
        if (upEndStation.equals(downEndStation)) {
            throw new IllegalArgumentException(TWO_STATIONS_SAME_ERROR_MESSAGE);
        }
    }

    public static ResultDto deleteLine(String lineName) {
        return ErrorUtils.produceResponse(() -> {
            checkExistLine(lineName);
            repository.deleteLineByName(lineName);
            return ResultDto.ok(DELETE_RESULT_OK_MESSAGE);
        });
    }

    private static void checkExistLine(String lineName) {
        repository.checkLineExist(lineName);
    }

    public static ResultDto findAllStationNames() {
        StringBuilder lineNames = new StringBuilder();
        List<Line> lines = repository.findAll();
        for (Line line : lines) {
            lineNames.append(ResultDto.RESULT_OK_PREFIX + line.getName() + "\n");
        }

        ResultDto result = ResultDto.ok("");
        result.setContent(lineNames.toString());
        return result;
    }

    public static void checkStationOnAnySubwayLine(String stationName) {
        if (repository.isStationOnLine(stationName)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_ON_LINE_STATION_ERROR_MESSAGE);
        }
    }

    public static void checkStationOnSubwayLine(String stationName, String lineName) {
        Line line = repository.findByName(lineName);
        if (line.isStationInLine(stationName)) {
            throw new IllegalArgumentException(ALREADY_EXISTS_ERROR_MESSAGE);
        }
    }

    public static Line findByName(String lineName) {
        return repository.findByName(lineName);
    }

    public static List<Line> findAll() {
        return repository.findAll();
    }
}
