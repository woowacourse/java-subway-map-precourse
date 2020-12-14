package subway.station;

import org.junit.jupiter.api.Test;
import subway.line.LineService;
import subway.model.Status;
import subway.section.SectionService;

import static org.junit.jupiter.api.Assertions.*;

class StationServiceTest {

    @Test
    void 지하철역_등록_중복_예외처리() {
        // given, when
        String stationName1 = "옥수역";

        // then
        assertEquals(Status.OK, StationService.registerStation(stationName1).getStatus());
        assertEquals(Status.BAD, StationService.registerStation(stationName1).getStatus());
    }

    @Test
    void 지하철역_삭제_존재하지_않는_역삭제_예외처리() {
        // given
        String stationName1 = "옥수역";
        String notRegistedStationName = "가나다라역";

        // when
        StationService.registerStation(stationName1);

        // then
        assertEquals(Status.BAD, StationService.deleteStation(notRegistedStationName).getStatus());
    }

    @Test
    void 지하철역_삭제_노선에_등록된_역삭제_예외처리() {
        // given
        String stationName1 = "옥수역";

        // when
        SectionService.registerSection("2호선", stationName1, 2);

        // then
        assertEquals(Status.BAD, StationService.deleteStation(stationName1).getStatus());
    }

}