package subway.view;

import static subway.view.MainMenu.WRONG_MENU_INPUT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import subway.controller.Management;
import subway.exception.SubwayCustomException;

public enum SectionMenu {
    ADD_SECTION("1", Management::addSection),
    DELETE_SECTION("2", Management::deleteSection),
    BACK("B", null);

    private final String input;
    private final Runnable handler;

    SectionMenu(String input, Runnable handler) {
        this.input = input;
        this.handler = handler;
    }

    public static void execute(String input) {
        try {
            Arrays.stream(values())
                .filter(value -> value.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new SubwayCustomException(WRONG_MENU_INPUT_EXCEPTION_MESSAGE))
                .handler.run();
        } catch (NullPointerException exception) {

        }
    }
}
