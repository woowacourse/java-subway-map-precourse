package subway.menu;

import subway.controller.MainMenuHandler;

import java.util.Arrays;

public enum MainMenu {
    STATION_MANAGE("1", MainMenuHandler::stationManage),
    LINE_MANAGE("2", MainMenuHandler::lineManage),
    SECTION_MANAGE("3", MainMenuHandler::sectionManage),
    SHOW_SUBWAY_MAP("4", MainMenuHandler::showSubwayMap),
    QUIT("Q", MainMenuHandler::end);

    MainMenu(String command, Runnable action) {
        this.command = command;
        this.action = action;
    }

    private String command;
    private Runnable action;

    public static MainMenu findByCommand(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equals(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("asd");
                });
    }

    public void run(){
        this.action.run();
    };
}
