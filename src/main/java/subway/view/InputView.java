package subway.view;

import subway.view.menu.LineMenu;
import subway.view.menu.MainMenu;
import subway.view.menu.Menu;
import subway.view.menu.StationMenu;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String ERROR_INVALID_INPUT_VALUE = "유효하지 않은 입력입니다.";
    private static final String SHARP_PREFIX = "## ";
    private static final String MENU_SELECTION = "원하는 기능을 선택하세요.";
    private static final String TO_REGISTER_PREFIX = "등록할 ";
    private static final String TO_DELETE_PREFIX = "삭제할 ";
    private static final String REQUEST_STATION_NAME = "역 이름을 입력하세요.";
    private static final String REQUEST_LINE_NAME = "노선 이름을 입력하세요.";
    private static final String REQUEST_UPLINE_NAME = "노선의 상행 종점역 이름을 입력하세요.";
    private static final String REQUEST_DOWNLINE_NAME = "노선의 하행 종점역 이름을 입력하세요.";

    private static Scanner scanner;
    private static MainMenu mainMenu = MainMenu.getInstance();
    private static StationMenu stationMenu = StationMenu.getInstance();
    private static LineMenu lineMenu = LineMenu.getInstance();

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static void showSelectionMessage() {
        System.out.println(SHARP_PREFIX + MENU_SELECTION);
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

    public static String getLineMenuSelection() {
        return getMenuSelection(lineMenu);
    }

    public static String getStationNameToRegister() {
        return getNameWithMessage(TO_REGISTER_PREFIX, REQUEST_STATION_NAME);
    }

    public static String getStationNameToDelete() {
        return getNameWithMessage(TO_DELETE_PREFIX, REQUEST_STATION_NAME);
    }

    public static String getLineNameToRegister() {
        return getNameWithMessage(TO_REGISTER_PREFIX, REQUEST_LINE_NAME);
    }

    public static String getLineNameToDelete() {
        return getNameWithMessage(TO_DELETE_PREFIX, REQUEST_LINE_NAME);
    }

    public static String getUplineStationName() {
        return getNameWithMessage(TO_REGISTER_PREFIX, REQUEST_UPLINE_NAME);
    }

    public static String getDownlineStationName() {
        return getNameWithMessage(TO_REGISTER_PREFIX, REQUEST_DOWNLINE_NAME);
    }

    private static String getNameWithMessage(String prefix, String requestMessage) {
        System.out.println(SHARP_PREFIX + prefix + requestMessage);
        try {
            String name = deleteWhiteSpaces(scanner.nextLine());
            newLine();
            isNotEmptyStringOrThrowException(name);
            return name;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getNameWithMessage(prefix, requestMessage);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
