package subway.station;

import subway.line.LineService;
import subway.model.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    private static final String REGISTER_RESULT_OK_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_RESULT_OK_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static final StationRepository repository = new StationRepository();

    private StationService() {}

    public static ResultDto registerStation(String stationName) {
        try {
            checkDuplicateStation(stationName);
            repository.addStation(new Station(stationName));
            return ResultDto.ok(REGISTER_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }

    private static void checkDuplicateStation(String stationName) {
        repository.checkDuplicateStation(stationName);
    }

    public static ResultDto deleteStation(String stationName) {
        try {
            checkDeleteException(stationName);
            repository.deleteStation(stationName);
            return ResultDto.ok(DELETE_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }

    }

    private static void checkDeleteException(String stationName) {
        LineService.checkStationOnAnySubwayLine(stationName);
        checkExistStation(stationName);
    }

    public static void checkExistStation(String stationName) {
        repository.checkStationExist(stationName);
    }

    public static ResultDto findAllStationNames() {
        StringBuilder stationNames = new StringBuilder();
        List<Station> stations = repository.findAll();
        for (Station station : stations) {
            stationNames.append(ResultDto.RESULT_OK_PREFIX + station.getName() + "\n");
        }

        ResultDto result = ResultDto.ok("");
        result.setContent(stationNames.toString());
        return result;
    }
}
