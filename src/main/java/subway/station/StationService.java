package subway.station;

import subway.line.LineService;
import subway.model.ResultDto;

import java.util.List;
import java.util.stream.Collectors;

public class StationService {

    private static final StationService INSTANCE = new StationService();
    private static final String REGISTER_RESULT_OK_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_RESULT_OK_MESSAGE = "지하철 역이 삭제되었습니다.";

    private final LineService lineService = LineService.getInstance();

    private StationService() {}

    public static StationService getInstance() {
        return INSTANCE;
    }

    public ResultDto registerStation(String stationName) {
        try {
            checkDuplicateStation(stationName);
            StationRepository.addStation(new Station(stationName));
            return ResultDto.ok(REGISTER_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }

    private void checkDuplicateStation(String stationName) {
        StationRepository.checkDuplicateStation(stationName);
    }

    public ResultDto deleteStation(String stationName) {
        try {
            checkDeleteException(stationName);
            StationRepository.deleteStation(stationName);
            return ResultDto.ok(DELETE_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }

    }

    private void checkDeleteException(String stationName) {
        lineService.checkStationOnAnySubwayLine(stationName);
        checkExistStation(stationName);
    }

    private void checkExistStation(String stationName) {
        StationRepository.checkStationExist(stationName);
    }

    public ResultDto findAllStationNames() {
        StringBuilder stationNames = new StringBuilder();
        List<Station> stations = StationRepository.findAll();
        for (Station station : stations) {
            stationNames.append(ResultDto.RESULT_OK_PREFIX + station.getName() + "\n");
        }

        ResultDto result = ResultDto.ok("");
        result.setContent(stationNames.toString());
        return result;
    }
}
