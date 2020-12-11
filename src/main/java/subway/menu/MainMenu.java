package subway.menu;

import static subway.view.TextFixtures.WRONG_MENU_INPUT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import subway.controller.manager.LineManager;
import subway.controller.manager.MainManager;
import subway.controller.manager.SectionManager;
import subway.controller.manager.StationManager;
import subway.exception.SubwayCustomException;
import subway.view.OutputView;

public enum MainMenu {
    MANAGE_STATION("1", StationManager::manageStation),
    MANAGE_LINE("2", LineManager::manageLine),
    MANAGE_SECTION("3", SectionManager::mangeSection),
    MANAGE_SUBWAY("4", OutputView::showSubwayLineMap),
    MANAGE_QUIT("Q", MainManager::end);


    private final String input;
    private final Runnable handler;

    MainMenu(String input, Runnable handler) {
        this.input = input;
        this.handler = handler;
    }

    public static void execute(String input) {
        Arrays.stream(values())
            .filter(value -> value.input.equals(input))
            .findFirst()
            .orElseThrow(() -> new SubwayCustomException(WRONG_MENU_INPUT_EXCEPTION_MESSAGE))
            .handler.run();
    }
}

