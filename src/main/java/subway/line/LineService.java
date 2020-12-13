package subway.line;

import subway.station.StationService;

public class LineService {

    private static final LineService INSTANCE = new LineService();

    private LineService() {}

    public static LineService getInstance() {
        return INSTANCE;
    }

    public void checkStationOnAnySubwayLine(String stationName) {
        if (LineRepository.isStationOnLine(stationName)) {
            throw new IllegalArgumentException("노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
