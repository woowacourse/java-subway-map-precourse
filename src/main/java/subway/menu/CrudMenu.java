package subway.menu;

import subway.controller.CrudMenuHandler;

import java.util.Arrays;

public enum CrudMenu {
    ADD("1", CrudMenuHandler::add),
    DELETE("2", CrudMenuHandler::delete),
    SHOW("3", CrudMenuHandler::show),
    BACK("B", () -> {});

    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    CrudMenu(String command, Runnable action) {
        this.command = command;
        this.action = action;
    }

    private final String command;
    private final Runnable action;

    public static CrudMenu findByCommand(String command) {
        return Arrays.stream(CrudMenu.values())
                .filter(StationMenu -> StationMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERR_NO_SUCH_MENU_MSG);
                });
    }

    public void run(){
        this.action.run();
    }
}
