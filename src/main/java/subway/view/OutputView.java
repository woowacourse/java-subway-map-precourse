package subway.view;

import subway.view.menu.Selection;
import subway.view.menu.LineMenu;
import subway.view.menu.MainMenu;
import subway.view.menu.Menu;
import subway.view.menu.StationMenu;

import java.util.List;

public class OutputView {
    private static final String SHARP_PREFIX = "## ";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INFO_PREFIX = "[INFO] ";
    private static final String MENU_FORMAT = "%s. %s";
    private static final String STATIONS_LIST = "역 목록";
    private static final String STATION_REGISTER = "지하철 역이 등록되었습니다.";
    private static final String STATION_DELETE = "지하철 역이 삭제되었습니다.";
    private static final String LINE_LIST = "노선 목록";
    private static final String LINE_REGISTER = "지하철 노선이 등록되었습니다.";
    private static final String LINE_DELETE = "지하철 노선이 삭제되었습니다.";

    private static MainMenu mainMenu = MainMenu.getInstance();
    private static StationMenu stationMenu = StationMenu.getInstance();
    private static LineMenu lineMenu = LineMenu.getInstance();

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
        newLine();
    }

    public static void showMainMenu() {
        showMenu(mainMenu);
    }

    public static void showStationManagementView() {
        showMenu(stationMenu);
    }

    public static void showLineManagementView() {
        showMenu(lineMenu);
    }

    public static void showMenu(Menu menu) {
        System.out.println(SHARP_PREFIX + menu.getViewName());
        for (Selection selection : menu.selections()) {
            System.out.println(String.format(MENU_FORMAT, selection.getValue(), selection.getDescription()));
        }
        newLine();
    }

    private static void printWithInfoPrefix(String string) {
        System.out.println(INFO_PREFIX + string);
    }

    public static void printStationRegisterDone() {
        printWithInfoPrefix(STATION_REGISTER);
        newLine();
    }

    public static void printStationDeleteDone() {
        printWithInfoPrefix(STATION_DELETE);
        newLine();
    }

    public static void printLineRegisterDone() {
        printWithInfoPrefix(LINE_REGISTER);
        newLine();
    }

    public static void printLineDeleteDone() {
        printWithInfoPrefix(LINE_DELETE);
        newLine();
    }

    private static void printAll(List<String> resultList) {
        for(String result : resultList) {
            printWithInfoPrefix(result);
        }
        newLine();
    }

    public static void printStations(List<String> stations) {
        System.out.println(SHARP_PREFIX + STATIONS_LIST);
        printAll(stations);
    }

    public static void printLines(List<String> lines) {
        System.out.println(SHARP_PREFIX + LINE_LIST);
        printAll(lines);
    }

    private static void newLine() {
        System.out.println();
    }
}
