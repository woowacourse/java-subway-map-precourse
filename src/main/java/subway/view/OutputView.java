package subway.view;


import subway.menu.LineMenu;
import subway.menu.MainMenu;
import subway.menu.StationMenu;

import java.util.List;

public class OutputView {
    public static final String DOT_AND_BLANK = ". ";
    public static final String MAIN_MENU_HEADER = "## 메인 화면";
    public static final String STATION_MENU_HEADER = "## 역 관리 화면";
    public static final String LINE_MENU_HEADER = "## 노선 관리 화면";
    public static final String SECTION_MENU_HEADER = "## 구간 관리 화면";
    public static final String PLEASE_SELECT_MENU_MSG = "## 원하는 기능을 선택하세요.";
    public static final String ADD_NAME_MSG_FORMAT = "## 등록할 %s 이름을 입력하세요.";
    public static final String DELETE_NAME_MSG_FORMAT = "삭제할 %s 이름을 입력하세요.";
    public static final String INFO_PREFIX_MSG = "[INFO] ";

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
        List<String> commands = LineMenu.getCommands();
        List<String> titles = LineMenu.getTitles();
        println(convertMenuToStringForConsoleOutput(header, commands, titles));
        println(PLEASE_SELECT_MENU_MSG);
    }

    public static void showAddMessage(String subject) {
        println(String.format(ADD_NAME_MSG_FORMAT, subject));
    }

    public static void showDeleteMessage(String subject) {
        println(String.format(DELETE_NAME_MSG_FORMAT, subject));
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

    public static void showList(List<String> names) {
        names.stream()
                .map(INFO_PREFIX_MSG::concat)
                .forEach(System.out::println);
        System.out.println();
    }
}
