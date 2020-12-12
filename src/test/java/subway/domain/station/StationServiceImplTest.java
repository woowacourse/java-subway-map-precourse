package subway.domain.station;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.MemoryLineRepository;
import subway.domain.section.MemorySectionRepository;
import subway.domain.section.SectionService;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.station.dto.StationDeleteReqDto;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.StationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationServiceImplTest {

    SectionService sectionService;
    StationService stationService;

    @BeforeEach
    void before() {
        sectionService = new SectionService(MemoryLineRepository.of(), MemoryStationRepository.of(), MemorySectionRepository.of());
        stationService = new StationServiceImpl(MemoryStationRepository.of(), MemorySectionRepository.of());
        String stationName = "행복역";
        String stationName2 = "사랑역";
        String stationName3 = "희망역";
        String stationName4 = "소망역";
        stationService.saveStation(new StationSaveReqDto(stationName));
        stationService.saveStation(new StationSaveReqDto(stationName2));
        stationService.saveStation(new StationSaveReqDto(stationName3));
        stationService.saveStation(new StationSaveReqDto(stationName4));

        String lineName = "1호선";
        String upwardName = "행복역";
        String downwardName = "사랑역";
        sectionService.saveSection(new SectionSaveReqDto(lineName,upwardName,downwardName));
    }

    @AfterEach
    void after() {
        stationService.removeAll();
        sectionService.removeAll();
    }

    @Test
    @DisplayName("이미 등록된 지하철 역일 시 에러가 발생한다. ")
    void testDuplicateSave() {
        //given
        String name = "인천시청역";
        String name2 = "인천시청역";

        //when
        Station savedIncheonStation = stationService.saveStation(new StationSaveReqDto(name));

        //then
        assertThatThrownBy(() -> stationService.saveStation(new StationSaveReqDto(name2)))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_ALREADY_EXIST.getMessage());
    }

    @Test
    @DisplayName("역을 삭제한다.")
    void testStationDelete() {
        //given
        String name = "희망역";

        //when
        boolean isDelete = stationService.deleteStation(new StationDeleteReqDto(name));

        //then
        assertThat(isDelete).isEqualTo(true);
    }

    @Test
    @DisplayName("삭제하려는 역이 노선에 포함되면 에러가 발생한다.")
    void testStationDeleteError() {
        //given
        String name = "행복역";

        //when

        //then
        assertThatThrownBy(() -> stationService.deleteStation(new StationDeleteReqDto(name)))
                .isInstanceOf(StationException.class)
                .hasMessage(ErrorCode.STATION_IN_LINE.getMessage());
    }
}