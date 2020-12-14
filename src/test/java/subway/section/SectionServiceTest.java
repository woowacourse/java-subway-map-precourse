package subway.section;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.line.LineService;
import subway.model.Status;
import subway.station.StationService;

import static org.junit.jupiter.api.Assertions.*;

class SectionServiceTest {

    @BeforeEach
    void setUp() {
        String stationName1 = "강남역";
        String stationName2 = "방배역";
        String stationName3 = "교대역";
        StationService.registerStation(stationName1);
        StationService.registerStation(stationName2);
        StationService.registerStation(stationName3);

        LineService.registerLine("2호선", stationName1, stationName2);
    }

    @Test
    void 구간_등록_존재하지않는_역_노선_예외처리_테스트() {
        // given, when
        String unRegistedStation = "가나다라역";
        String unRegistedLine = "가나다라호선";

        // then
        assertEquals(Status.BAD, SectionService.registerSection(unRegistedLine, unRegistedStation, 1).getStatus());
    }

    @Test
    void 구간_등록_노선에_이미_존재하는_역_예외처리_테스트() {
        // given, when
        String alreadyRegistedStation = "강남역";

        // then
        assertEquals(Status.BAD, SectionService.registerSection("2호선", alreadyRegistedStation, 2).getStatus());
    }

    @Test
    void 구간_등록_노선의_범위를_벗어나는_위치_예외처리_테스트() {
        // given, when, then
        assertEquals(Status.BAD, SectionService.registerSection("2호선", "교대역", 50).getStatus());
    }

    @Test
    void 구간_삭제_노선에_포함된_역이_두개이하_예외처리_테스트() {
        // given, when, then
        assertEquals(Status.BAD, SectionService.deleteSection("2호선", "강남역").getStatus());
    }

    @Test
    void 구간_삭제_노선에_존재하지_않는_역_예외처리_테스트() {
        // given, when, then
        assertEquals(Status.BAD, SectionService.deleteSection("2호선", "가나다라역").getStatus());
    }
}