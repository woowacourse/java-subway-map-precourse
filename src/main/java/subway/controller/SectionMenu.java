package subway.controller;

import java.util.Arrays;
import subway.utils.Message;

public enum SectionMenu implements Message {
    INSERT("1", SectionManager::insertStationInLine),
    REMOVE("2", SectionManager::removeStationFromLine);

    private final String input;
    private final Runnable handler;

    SectionMenu(String input, Runnable handler) {
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
