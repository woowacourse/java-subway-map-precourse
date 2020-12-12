package subway.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.InputView;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StationServiceTest {

    final StationService stationService = new StationService();

    @Test
    @DisplayName("역을 등록할 수 있다")
    public void stationAddTest() throws Exception{
        Scanner scanner = new Scanner("bepoz");
        InputView inputView = new InputView(scanner);
        boolean result = stationService.addStation(inputView);
        assertTrue(result);
    }

    @Test
    @DisplayName("역 이름은 2글자 이상이어야 한다.")
    public void stationNameLessThan2AddTest() throws Exception{
        Scanner scanner = new Scanner("가");
        InputView inputView = new InputView(scanner);
        boolean result = stationService.addStation(inputView);
        assertFalse(result);
    }

    @Test
    @DisplayName("중복된 역 이름이 입력되어서는 안됩니다.")
    public void stationNameDuplicateTest() throws Exception{
        Scanner scanner = new Scanner("가나");
        InputView inputView = new InputView(scanner);
        stationService.addStation(inputView);
        Scanner scanner2 = new Scanner("가나");
        InputView inputView2 = new InputView(scanner2);
        boolean result = stationService.addStation(inputView2);
        assertFalse(result);
    }

    @Test
    @DisplayName("역을 조회할 수 있다")
    public void printStationListTest() throws Exception{
        StationRepository.addStation(new Station("잠실"));
        StationRepository.addStation(new Station("당산"));
        StationRepository.addStation(new Station("홍대입구"));

        StationService stationService = new StationService();
        stationService.printStationList();
    }

}