package subway.domain.station;

import subway.util.MenuPrinter;
import subway.util.MenuSelectManager;
import subway.util.PrefixPrinter;

import java.util.Scanner;

public class StationController implements MenuSelectManager {
    private static final String BACK = "B";
    private static final String ADD_STATION = "1";
    private static final String DELETE_STATION = "2";
    private static final String GET_STATIONS = "3";
    private final StationService stationService = new StationService();

    @Override
    public void selectMenu(Scanner scanner) {
        MenuPrinter.printStationMenu();
        String menuInput = scanner.next();
        while (!menuInput.equals(BACK) && !forward(menuInput, scanner)) {
            MenuPrinter.printStationMenu();
            menuInput = scanner.next();
        }
        System.out.println();
    }

    private boolean forward(String menuInput, Scanner scanner) {
        System.out.println();
        if (menuInput.equals(ADD_STATION)) {        // 역 등록
            return stationService.addStation(scanner);
        }
        if (menuInput.equals(DELETE_STATION)) {     // 역 삭제
            return stationService.deleteStation(scanner);
        }
        if (menuInput.equals(GET_STATIONS)) {       // 역 조회
            stationService.getStation();
            return true;
        }
        PrefixPrinter.printError("선택할 수 없는 기능입니다.");
        return false;
    }
}
