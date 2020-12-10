package subway.view;

import subway.view.menu.MainMenu;
import subway.view.menu.Menu;
import subway.view.menu.StationMenu;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String ERROR_INVALID_INPUT_VALUE = "유효하지 않은 입력입니다.";
    private static final String SELECTION_PREFIX = "## ";
    private static final String MENU_SELECTION = "원하는 기능을 선택하세요.";
    private static final String TO_REGISTER_PREFIX = "등록할 ";
    private static final String TO_DELETE_PREFIX = "삭제할 ";
    private static final String REQUEST_STATION_REGISTER = "역 이름을 입력하세요.";

    private static Scanner scanner;
    private static MainMenu mainMenu = MainMenu.getInstance();
    private static StationMenu stationMenu = StationMenu.getInstance();

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static void showSelectionMessage() {
        System.out.println(SELECTION_PREFIX + MENU_SELECTION);
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "" );
    }

    private static boolean isNotEmptyStringOrThrowException(String string) {
        if (string.equals("" )) {
            throw new IllegalArgumentException(ERROR_NONE_INPUT_VALUE);
        }
        return true;
    }

    public static String getMenuSelection(Menu menu) {
        showSelectionMessage();
        try {
            String string = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrowException(string);
            if (!menu.getMenuSelections().contains(string)) {
                throw new IllegalArgumentException(ERROR_INVALID_INPUT_VALUE);
            }
            newLine();
            return string;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getMenuSelection(menu);
        }
    }

    public static String getMainMenuSelection() {
        return getMenuSelection(mainMenu);
    }

    public static String getStationMenuSelection() {
        return getMenuSelection(stationMenu);
    }

    public static String getStationNameToRegister() {
        return getStationName(TO_REGISTER_PREFIX);
    }

    public static String getStationNameToDelete() {
        return getStationName(TO_DELETE_PREFIX);
    }

    private static String getStationName(String prefix) {
        System.out.println(SELECTION_PREFIX + prefix + REQUEST_STATION_REGISTER);
        try {
            String name = deleteWhiteSpaces(scanner.nextLine());
            newLine();
            isNotEmptyStringOrThrowException(name);
            return name;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            newLine();
            return getStationName(prefix);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
