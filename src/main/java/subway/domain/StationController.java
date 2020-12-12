package subway.domain;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;

import java.util.Scanner;

public class StationController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String GET_STATIONS = "3";

    @Override
    public void forward(Scanner scanner) {
        StationService stationService = new StationService();
        MenuPrinter.printStationMenu();
        String menuInput = scanner.next();
        if (menuInput.equals(BACK)) {
            return;
        }
        if (menuInput.equals(ADD_STATION)) { // 역 등록
            stationService.addStation(scanner);
        }
        if (menuInput.equals(DELETE_STATION)) { // 역 삭제
            stationService.deleteStation(scanner);
        }
        if (menuInput.equals(GET_STATIONS)) { // 역 조회
            stationService.getStation();
        }
        System.out.println();
    }
}
