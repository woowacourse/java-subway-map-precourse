package subway.domain.section;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.line.MemoryLineRepository;
import subway.domain.section.dto.SectionDeleteReqDto;
import subway.domain.section.dto.SectionSaveReqDto;
import subway.domain.section.dto.SectionStationDeleteReqDto;
import subway.domain.station.MemoryStationRepository;
import subway.domain.station.Station;
import subway.domain.station.StationService;
import subway.domain.station.StationServiceImpl;
import subway.domain.station.dto.StationSaveReqDto;
import subway.exception.ErrorCode;
import subway.exception.SectionException;

import static org.assertj.core.api.Assertions.*;

class SectionServiceTest {

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
        sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName));
        sectionService.addStation(lineName, stationName3, 2);
    }

    @AfterEach
    void after() {
        stationService.removeAll();
        sectionService.removeAll();
    }

    @Test
    @DisplayName("노선을 저장한다")
    void testSaved() {
        //given
        String lineName = "2호선";
        String upwardName = "희망역";
        String downwardName = "소망역";

        //when
        Section savedSection = sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName));

        //then
        assertThat(savedSection.getLineName()).isEqualTo(lineName);
    }

    @Test
    @DisplayName("이미 저장된 노선일 시 에러가 발생한다.")
    void testAlreadySavedError() {
        //given
        String lineName = "1호선";
        String upwardName = "희망역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.LINE_ALREADY_EXIST.getMessage());
    }

    @Test
    @DisplayName("등룍하려는 상행 종점역이 존재하지 않으면 에러가 발생한다")
    void testUpwardNotFound() {
        //given
        String lineName = "2호선";
        String upwardName = "역곡역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_UPWARD_STATION_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("등룍하려는 하행 종점역이 존재하지 않으면 에러가 발생한다")
    void testDownwardNotFound() {
        //given
        String lineName = "2호선";
        String upwardName = "소망역";
        String downwardName = "역곡역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_DOWNWARD_STATION_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("등룍하려는 하행 종점역이 앞서 등록한 상행 종점역일 시 에러가 발생한다")
    void testDownwardSaveError() {
        //given
        String lineName = "2호선";
        String upwardName = "소망역";
        String downwardName = "소망역";

        //then
        assertThatThrownBy(() -> sectionService.saveSection(new SectionSaveReqDto(lineName, upwardName, downwardName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_SAME_STATION_NAME.getMessage());
    }

    @Test
    @DisplayName("등룍된 노선 삭제")
    void testDelete() {
        //given
        String lineName = "1호선";

        //when
        boolean isDelete = sectionService.deleteSection(new SectionDeleteReqDto(lineName));

        //then
        assertThat(isDelete).isEqualTo(true);
        assertThatThrownBy(() -> sectionService.findByName(lineName))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("등록되지 않은 노선을 삭제할 시 에러가 발생한다.")
    void testDeleteError() {
        //given
        String lineName = "2호선";

        //then
        assertThatThrownBy(() -> sectionService.deleteSection(new SectionDeleteReqDto(lineName)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_NOT_FOUND.getMessage());
    }

    @Test
    @DisplayName("현재 노선에 동일한 역이 있을 시 에러가 발생한다. ")
    void testAddStation() {
        //given
        String lineName = "1호선";
        String stationName = "행복역";

        //when
        Section section = sectionService.findByName(lineName);
        Station station = stationService.findByName(stationName);

        //then
        assertThatThrownBy(() -> sectionService.checkContainStation(section, station))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_HAS_STATION.getMessage());
    }

    @Test
    @DisplayName("순서에 맞춰 역을 추가한다. ")
    void testAddStationLine() {
        //given
        String lineName = "1호선";
        String stationName = "희망역";
        int sequence = 2;

        //when
        sectionService.addStation(lineName, stationName, sequence);
        Section section = sectionService.findByName(lineName);

        //then
        assertThat(section.getStationsName().get(1)).isEqualTo(stationName);
    }

    @Test
    @DisplayName("입력된 순서가 구간에 등록된 역의 사이즈 보다 크면 제일 마지막에 추가한다. ")
    void testAddStationLineLength() {
        //given
        String lineName = "1호선";
        String stationName = "희망역";
        int sequence = 3;

        //when
        sectionService.addStation(lineName, stationName, sequence);
        Section section = sectionService.findByName(lineName);

        //then
        assertThat(section.getStationsName().get(2)).isEqualTo(stationName);
    }

    @Test
    @DisplayName("노선에 포함되어있는 역 삭제 테스트")
    void testDeleteStation() {
        //given
        String lineName = "1호선";
        String stationName = "희망역";


        //when
        boolean isDelete = sectionService.deleteStation(new SectionStationDeleteReqDto(lineName, stationName));

        //then
        assertThat(isDelete).isEqualTo(true);
    }

    @Test
    @DisplayName("노선에 포함되어있는 역이 두개 이하면 에러가 발생한다.")
    void testDeleteStationLengthError() {
        //given
        String lineName = "1호선";
        String stationName = "희망역";
        String stationName2 = "행복역";


        //when
        boolean isDelete = sectionService.deleteStation(new SectionStationDeleteReqDto(lineName, stationName));

        //then
        assertThat(isDelete).isEqualTo(true);
        assertThatThrownBy(() -> sectionService.deleteStation(new SectionStationDeleteReqDto(lineName, stationName2)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_CANNOT_DELETE_STATION.getMessage());
    }

    @Test
    @DisplayName("삭제하려는 역이 노선에 포함되있지 않으면 에러가 발생한다.")
    void testDeleteStationNotHasError() {
        //given
        String lineName = "1호선";
        String stationName = "희망역";
        String stationName2 = "희망역";

        //when
        boolean isDelete = sectionService.deleteStation(new SectionStationDeleteReqDto(lineName, stationName));

        //then
        assertThat(isDelete).isEqualTo(true);
        assertThatThrownBy(() -> sectionService.deleteStation(new SectionStationDeleteReqDto(lineName, stationName2)))
                .isInstanceOf(SectionException.class)
                .hasMessage(ErrorCode.SECTION_NOT_HAS_STATION.getMessage());
    }
}