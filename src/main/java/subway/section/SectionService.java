package subway.section;

import subway.line.Line;
import subway.line.LineService;
import subway.model.ResultDto;
import subway.station.Station;
import subway.station.StationService;

public class SectionService {

    private static final String REGISTER_RESULT_OK_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_RESULT_OK_MESSAGE = "구간이 삭제되었습니다.";

    public static ResultDto registerSection(String lineName, String stationName, int order) {
        try {
            Station station = StationService.findByName(stationName);
            Line line = LineService.findByName(lineName);
            checkStationAlreadyOnLine(lineName, stationName);
            line.addStation(station,order);
            return ResultDto.ok(REGISTER_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }

    private static void checkStationAlreadyOnLine(String lineName, String stationName) {
        LineService.checkStationOnSubwayLine(stationName, lineName);
    }

    public static ResultDto deleteSection(String lineName, String stationName) {
        try {
            Line line = LineService.findByName(lineName);
            line.removeStationByName(stationName);
            return ResultDto.ok(DELETE_RESULT_OK_MESSAGE);
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }


}
