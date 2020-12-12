package subway.controller;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.AlreadyAddStationException;
import subway.exception.CannotRemoveException;
import subway.exception.StationNotFountException;
import subway.view.InputView;

import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StationControllerTest {

    private Scanner getScannerMock(String input) {

        Scanner mock = mock(Scanner.class);
        when(mock.nextLine()).thenReturn(input);
        return mock;
    }

    private Station saveAndFind(String name) {
        StationRepository stationRepository = new StationRepository();
        String input = "킹우정역";
        InputView.initScanner(getScannerMock(input));
        StationController controller = new StationController();
        controller.save();
        return stationRepository.findBy(input);
    }

    @Test
    @Description("역 추가")
    public void saveTestSuccess() {

        StationRepository stationRepository = new StationRepository();
        //given
        String input = "킹우정역";
        InputView.initScanner(getScannerMock(input));
        StationController controller = new StationController();

        //when
        controller.save();
        Station find = stationRepository.findBy(input);

        //then
        Assertions.assertTrue(find.isSameName(input));

    }

    @Test
    @Description("중복된 이름을 넣으면 예외 발생")
    public void saveTest() {

        //given
        String input = "강남역";
        InputView.initScanner(getScannerMock(input));
        StationController controller = new StationController();

        //when
        Assertions.assertThrows(AlreadyAddStationException.class, () -> {
            controller.save();

        });

    }

    @Test
    @Description("역 삭제 테스트")
    public void deleteTest() {

        String name = "우정역";
        Scanner scannerMock = getScannerMock(name);
        Station station1 = saveAndFind(name);

        StationController controller = new StationController();
        controller.delete();

        StationRepository stationRepository = new StationRepository();

        Assertions.assertThrows(StationNotFountException.class, () -> {
            Station by = stationRepository.findBy(name);
        });
    }

    @Test
    @Description("연결되어 있는 역을 삭제하면 예외 발생")
    public void deleteExceptionTest(){
        String name = "강남역";
        Scanner scannerMock = getScannerMock(name);
        InputView.initScanner(scannerMock);

        StationController controller = new StationController();
        controller.findBy();

        Assertions.assertThrows(CannotRemoveException.class, () -> {

            controller.delete();

        });

    }


}