package subway.menu;

import subway.controller.MainMenuHandler;
import subway.controller.StationMenuHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StationMenu {
    ADD_STATION("역 등록", "1", StationMenuHandler::addStation),
    DELETE_STATION("역 삭제", "2", StationMenuHandler::deleteStation),
    SHOW_STATIONS("역 조회", "3", StationMenuHandler::showStation),
    BACK("돌아가기", "B", StationMenuHandler::back);

    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    StationMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static StationMenu findByCommand(String command) {
        return Arrays.stream(StationMenu.values())
                .filter(StationMenu -> StationMenu.command.equals(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERR_NO_SUCH_MENU_MSG);
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(StationMenu.values())
                .map(stationMenu -> stationMenu.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(StationMenu.values())
                .map(stationMenu -> stationMenu.command)
                .collect(Collectors.toList());
    }

    public void run() {
        this.action.run();
    }
}
