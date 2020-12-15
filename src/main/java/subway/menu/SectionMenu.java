package subway.menu;

import subway.controller.SectionMenuHandler;
import subway.controller.StationMenuHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SectionMenu {
    ADD_SECTION("구간 등록", "1",SectionMenuHandler::addSection),
    DELETE_SECTION("구간 삭제", "2", SectionMenuHandler::deleteSection),
    BACK("돌아가기", "B",SectionMenuHandler::back);

    public static final String ERR_NO_SUCH_MENU_MSG = "[ERROR] 해당 메뉴가 없습니다.";

    SectionMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static SectionMenu findByCommand(String command) {
        return Arrays.stream(SectionMenu.values())
                .filter(sectionMenu -> sectionMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(ERR_NO_SUCH_MENU_MSG);
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(SectionMenu.values())
                .map(sectionMenu -> sectionMenu.title)
                .collect(Collectors.toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(SectionMenu.values())
                .map(sectionMenu -> sectionMenu.command)
                .collect(Collectors.toList());
    }

    public void run() {
        this.action.run();
    }
}
