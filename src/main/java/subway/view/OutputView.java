package subway.view;

import static subway.util.TextConstant.*;

import subway.menu.LineMenu;
import subway.menu.MainMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;

import java.util.*;

public class OutputView {
    public static void showMainMenu() {
        String header = MAIN_MENU_HEADER + System.lineSeparator();
        List<String> commands = MainMenu.getCommands();
        List<String> titles = MainMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        println(PLEASE_SELECT_MENU_MSG);
    }

    public static void showStationMenu() {
        String header = STATION_MENU_HEADER + System.lineSeparator();
        List<String> commands = StationMenu.getCommands();
        List<String> titles = StationMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        println(PLEASE_SELECT_MENU_MSG);
    }

    public static void showLineMenu() {
        String header = LINE_MENU_HEADER + System.lineSeparator();
        List<String> commands = LineMenu.getCommands();
        List<String> titles = LineMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        println(PLEASE_SELECT_MENU_MSG);
    }

    public static void showSectionMenu() {
        String header = SECTION_MENU_HEADER + System.lineSeparator();
        List<String> commands = SectionMenu.getCommands();
        List<String> titles = SectionMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        println(PLEASE_SELECT_MENU_MSG);
    }

    public static void showRequestInputForAddMessage(String subject) {
        println(String.format(REQUEST_INPUT_FOR_ADD_NAME_MSG_FORMAT, subject));
    }

    public static void showRequestInputMessage(String subject) {
        println(String.format(REQUEST_INPUT_MSG_FORMAT, subject));
    }

    public static void showRequestInputForDeleteMessage(String subject) {
        println(String.format(REQUEST_INPUT_FOR_DELETE_NAME_MSG_FORMAT, subject));
    }

    public static void showList(List<String> names) {
        names.forEach(OutputView::showName);
        println(EMPTY_STRING);
    }

    public static void showName(String name) {
        println(INFO_PREFIX_MSG.concat(name));
    }
    public static void showCompleteMessage(String subject, String action) {
        println(EMPTY_STRING);
        println(String.format(INFO_COMPLETE_MSG_FORMAT, subject, action));
        println(EMPTY_STRING);
    }

    public static void showEmptyListMessage(String subject) {
        println(EMPTY_STRING);
        println(String.format(INFO_NO_ELEMENT_FORMAT, subject));
        println(EMPTY_STRING);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    private static String convertMenuToStringForConsoleOutput(String header, List<String> commands, List<String> titles) {
        StringBuilder menu = new StringBuilder(header);
        for (int i = 0; i < commands.size(); i++) {
            String menuLine = commands.get(i)
                    .concat(DOT_AND_BLANK)
                    .concat(titles.get(i))
                    .concat(System.lineSeparator());
            menu.append(menuLine);
        }
        return menu.toString();
    }

    public static void showValidSequence(int size) {
        println(String.format(VALID_NUMBER_RANGE_MSG_FORMAT, size));
    }

    public static void showSubwayMap(Map<String, List<String>> lineNamesAndStationNamesMap) {
        List<String> orderedLineNames = new ArrayList<>(lineNamesAndStationNamesMap.keySet());
        orderedLineNames.sort(Comparator.naturalOrder());
        orderedLineNames.forEach(
                lineName -> {
                    showName(lineName);
                    println(THREE_DASH);
                    showList(lineNamesAndStationNamesMap.get(lineName));
                }
        );
    }
}
