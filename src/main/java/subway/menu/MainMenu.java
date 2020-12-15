package subway.menu;

import subway.controller.MainMenuHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MainMenu {
    STATION_MANAGE("역 관리", "1", MainMenuHandler::stationManage),
    LINE_MANAGE("노선 관리", "2", MainMenuHandler::lineManage),
    SECTION_MANAGE("구간 관리", "3", MainMenuHandler::sectionManage),
    SHOW_SUBWAY_MAP("지하철 노선도 출력", "4", MainMenuHandler::showSubwayMap),
    QUIT("종료", "Q", MainMenuHandler::end);

    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    MainMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static MainMenu findByCommand(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equals(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERR_NO_SUCH_MENU_MSG);
                });
    }

    public void run() {
        this.action.run();
    }

    public static List<String> getTitles() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.command)
                .collect(Collectors.toList());
    }
}
