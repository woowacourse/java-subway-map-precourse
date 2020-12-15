package subway.menu;

import subway.controller.LineMenuHandler;
import subway.controller.SectionMenuHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LineMenu {
    ADD_LINE("라인 관리", "1", LineMenuHandler::addLine),
    DELETE_LINE("라인 삭제", "2", LineMenuHandler::deleteLine),
    SHOW_LINE("라인 조회", "3", LineMenuHandler::showLine),
    BACK("돌아가기", "B", LineMenuHandler::back);

    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    LineMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static LineMenu findByCommand(String command) {
        return Arrays.stream(LineMenu.values())
                .filter(lineMenu -> lineMenu.command.equals(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERR_NO_SUCH_MENU_MSG);
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(LineMenu.values())
                .map(lineMenu -> lineMenu.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(LineMenu.values())
                .map(lineMenu -> lineMenu.command)
                .collect(Collectors.toList());
    }

    public void run() {
        this.action.run();
    }
}
