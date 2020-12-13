package subway.controller;

import java.util.Arrays;
import subway.utils.Message;
import subway.view.OutputView;

public enum MainMenu implements Message{
    MANAGE_STATION("1", SubwayManager::manageStation),
    MANAGE_LINE("2", SubwayManager::manageLine),
    MANAGE_SECTION("3", SubwayManager::manageSection),
    PRINT_SUBWAY("4", OutputView::printWholeSection);

    private final String input;
    private final Runnable handler;

    MainMenu(String input, Runnable handler) {
        this.input = input;
        this.handler = handler;
    }

    public static void request(String selection) {
        Arrays.stream(values())
            .filter(value -> value.input.equals(selection))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_SELECTION))
            .handler.run();
    }
}
