package subway.station;

import subway.model.ResultDto;

public class StationService {

    private static final StationService INSTANCE = new StationService();
    private static final String RESULT_OK_MESSAGE = "지하철 역이 등록되었습니다.";

    private StationService() {}

    public static StationService getInstance() {
        return INSTANCE;
    }

    public ResultDto registerStation(String stationName) {
        try {
            checkDuplicateStation(stationName);
            StationRepository.addStation(new Station(stationName));
            return ResultDto.ok(RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }

    private void checkDuplicateStation(String stationName) {
        StationRepository.checkDuplicateStation(stationName);
    }
}
