package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Station;

public class StationDisplay extends Display {

    private static final String NOTICE_STATION = "역 관리 화면";
    private static final String ERROR_STATION = "선택할 수 없는 기능입니다.";
    private static final String SAVE_SUCCESS_STATION = "지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS_STATION = "지하철 역이 삭제되었습니다.";
    private static final String PRINT_ALL_STATIONS = "역 목록";

    public static void printSaveSuccess() {
        printInformation(SAVE_SUCCESS_STATION);
    }

    public static void printDeleteSuccess() {
        printInformation(DELETE_SUCCESS_STATION);
    }

    public static void printAllStations(List<Station> stations) {
        printNotice(PRINT_ALL_STATIONS);
        stations.stream().forEach(station -> printInformationList(station.getName()));
    }

    public static void loadStationMenu() {
        while (true) {
            printMenu();
            StationMenu selectedMenu = selectMenuByInput();
            try {
                selectedMenu.executeMenu(selectedMenu.getMenuKey());
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private static void printMenu() {
        printNotice(NOTICE_STATION);
        Arrays.stream(StationMenu.values()).forEach(
            stationMenu -> System.out
                .println(stationMenu.getMenuKey() + ". " + stationMenu.getMenuName()));
    }

    private static StationMenu selectMenuByInput() {
        while (true) {
            try {
                return StationMenu.getMenuByInput(UserInput.getMenu());
            } catch (NoSuchElementException e) {
                printError(ERROR_STATION);
            }
        }
    }
}
