package subway.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String STATION_MANAGEMENT = "역 관리";
    private static final String LINE_MANAGEMENT = "노선 관리";
    private static final String SECTION_MANAGEMENT = "구간 관리";
    private static final String SUBWAY_MAP = "지하철 노선도 출력";
    private static final String MENU_FORMAT = "%s. %s";
    private static final String QUIT = "종료";
    private static final int MENU_START_INDEX = 1;
    private static final int MAIN_MENU_LENGTH = 4;

    private static List<String> mainMenu = new ArrayList<>(Arrays.asList(
            STATION_MANAGEMENT, LINE_MANAGEMENT, SECTION_MANAGEMENT, SUBWAY_MAP, QUIT
    ));

    private static List<String> mainMenuSelections = new ArrayList<>();

    static {
        IntStream.rangeClosed(MENU_START_INDEX, MAIN_MENU_LENGTH)
                .mapToObj(Integer::toString)
                .forEach(mainMenuSelections::add);
        mainMenuSelections.add("Q");
    }

    public static void showErrorMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void showMainMenu() {
        Iterator<String> menuIterator = mainMenu.iterator();
        for (String index : mainMenuSelections) {
            System.out.println(String.format(MENU_FORMAT, index, menuIterator.next()));
        }
    }
}
