package subway.controller;

import java.util.Arrays;
import subway.utils.Message;
import subway.view.OutputView;

public enum LineMenu implements Message {
    REGISTER_LINE("1", LineManager::register),
    DELETE_LINE("2", LineManager::delete),
    PRINT_LINE("3", OutputView::printLines);

    private final String input;
    private final Runnable handler;

    LineMenu(String input, Runnable handler) {
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
