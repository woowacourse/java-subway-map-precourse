package subway.station;

import org.junit.jupiter.api.*;
import subway.domain.Station;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StationControllerTest {

    private StationController stationController;
    private StationRepository stationRepository;

    public StationControllerTest() {
        stationRepository = new StationRepositoryJava();
        stationController = new StationController(stationRepository);
    }

    @BeforeEach
    private void addDummyStations() {
        List<Station> stations = getDummyStations();
        stations.forEach(station -> stationRepository.addStation(station));
    }

    @AfterEach
    private void deleteDummyStations() {
        List<Station> stations = getDummyStations();
        stations.forEach(station -> stationRepository.deleteStation(station));
    }

    private List<Station> getDummyStations() {
        return Arrays.asList(
                Station.from("도봉산역"),
                Station.from("의정부역"),
                Station.from("회룡역")
        );
    }

    @Test
    @DisplayName("역 목록 가져오기")
    public void findAllStations() throws Exception {
        //given
        final int stationsSize = 3;
        //when
        List<StationDTO> stations = stationController.findStations();
        //then
        Assertions.assertEquals(stationsSize, stations.size());
    }

    @Test
    @DisplayName("역 이름 유효성 검사 실패")
    public void inputWrongStationName() throws Exception {
        //given
        final String expectedMessage = "지하철 역 이름은 2 글자 이상이어야 합니다.";
        final String name = "하";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> stationController.createStation(name));
        //then
        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("역 생성 성공")
    public void inputCorrectStationName() throws Exception {
        //given
        final String name = "서울역";
        //when
        stationController.createStation(name);
        //then
        StationDTO station = stationController.findStationByName(name);
        Assertions.assertEquals(name, station.getName());
    }

    @Test
    @DisplayName("존재하지 않는 역 삭제")
    public void removeNonexistentStation() throws Exception {
        //given
        final String expectedMessage = "존재하지 않는 역입니다.";
        final String nonexistentName = "가산디지털단지역";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> stationController.deleteStation(nonexistentName));
        //then
        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("존재하는 역 삭제")
    public void removeExistentStation() throws Exception {
        //given
        final String existentName = "의정부역";
        //when
        stationController.deleteStation(existentName);
        //then
        assertThrows(IllegalStateException.class, () -> stationController.findStationByName(existentName));
    }

    @Test
    @DisplayName("노선에 등록되어 있는 역 삭제")
    public void removeUnremovalStation() throws Exception {
        //given
        final String expectedMessage = "노선이 등록되어 있는 역입니다.";
        final String existentName = "의정부역";
        //when
        Station station = stationRepository.findStationByName(existentName).get();
        station.addLine();
        //then
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> stationController.deleteStation(existentName));

        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("존재하지 않는 역 검색")
    public void findNonexistentStation() throws Exception {
        //given
        final String expectedMessage = "존재하지 않는 역입니다.";
        final String nonexistentName = "가산디지털단지역";
        //when
        IllegalStateException illegalStateException =
                assertThrows(IllegalStateException.class, () -> stationController.findStationByName(nonexistentName));
        //then
        Assertions.assertEquals(expectedMessage, illegalStateException.getMessage());
    }

    @Test
    @DisplayName("존재하는 역 검색")
    public void findExistentStation() throws Exception {
        //given
        final String existentName = "의정부역";
        //when
        StationDTO stationByName = stationController.findStationByName(existentName);
        //then
        Assertions.assertEquals(stationByName.getName(), existentName);
    }
}