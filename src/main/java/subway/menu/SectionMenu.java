package subway.menu;

import static subway.view.TextFixtures.WRONG_MENU_INPUT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import subway.controller.manager.SectionManager;
import subway.exception.SubwayCustomException;

public enum SectionMenu {
    ADD_SECTION("1", SectionManager::addSection),
    DELETE_SECTION("2", SectionManager::deleteSection),
    BACK("B", () -> {
    });

    private final String input;
    private final Runnable handler;

    SectionMenu(String input, Runnable handler) {
        this.input = input;
        this.handler = handler;
    }

    public static void execute(String input) {
        Arrays.stream(values())
            .filter(value -> value.input.equals(input.toUpperCase()))
            .findFirst()
            .orElseThrow(() -> new SubwayCustomException(WRONG_MENU_INPUT_EXCEPTION_MESSAGE))
            .handler.run();
    }
}
