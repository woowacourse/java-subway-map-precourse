package subway.line;

import subway.model.ResultDto;
import subway.station.Station;
import subway.station.StationService;

public class LineService {

    private static final String REGISTER_RESULT_OK_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final LineRepository repository = new LineRepository();

    private LineService() {}

    public static void checkStationOnAnySubwayLine(String stationName) {
        if (repository.isStationOnLine(stationName)) {
            throw new IllegalArgumentException("노선에 등록된 역입니다.");
        }
    }

    public static ResultDto registerLine(String lineName, String upEndStation, String downEndStation) {
        try {
            checkDulicateLine(lineName);
            checkEndStations(upEndStation, downEndStation);
            repository.addLine(new Line(lineName, new Station(upEndStation), new Station(downEndStation)));
            return ResultDto.ok(REGISTER_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
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
            throw new IllegalArgumentException("상행 종점과 하행 종점은 같을 수 없습니다.");
        }
    }
}
