package subway.line;

import org.junit.jupiter.api.Test;
import subway.model.ResultDto;
import subway.model.Status;
import subway.station.StationService;

import static org.junit.jupiter.api.Assertions.*;

class LineServiceTest {

    @Test
    void 노선_등록_중복이름_예외처리_테스트() {
        // given
        String lineName = "2호선";
        String upEndStation = "강남역";
        String downEndStation = "교대역";
        StationService.registerStation(upEndStation);
        StationService.registerStation(downEndStation);

        // when
        LineService.registerLine(lineName, upEndStation, downEndStation);

        // then
        String sameLineName = lineName;
        ResultDto result = LineService.registerLine(sameLineName, upEndStation, downEndStation);
        assertEquals(Status.BAD, result.getStatus());
    }

    @Test
    void 노선_등록_상행종점과_하행_종점_동일_예외처리_테스트() {
        // given, when
        String lineName = "2호선";
        String upEndStation = "강남역";
        StationService.registerStation(upEndStation);

        // then
        ResultDto result = LineService.registerLine(lineName, upEndStation, upEndStation);
        assertEquals(Status.BAD, result.getStatus());
    }

    @Test
    void 노선_등록_상행_종점_혹은_하행_종점_존재여부_예외처리_테스트() {
        // given, when
        String lineName = "2호선";
        String upEndStation = "강남역";
        String downEndStation = "교대역";

        // then
        ResultDto result = LineService.registerLine(lineName, upEndStation, upEndStation);
        assertEquals(Status.BAD, result.getStatus());
    }

    @Test
    void 노선_삭제_존재하지_않는_노선_예외처리_테스트() {
        // given
        String lineName = "존재하지않는역";

        // then
        ResultDto result = LineService.deleteLine(lineName);
        assertEquals(Status.BAD, result.getStatus());
    }
}