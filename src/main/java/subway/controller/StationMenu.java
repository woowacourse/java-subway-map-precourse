package subway.controller;

import java.util.Arrays;
import subway.utils.Message;
import subway.view.OutputView;

public enum StationMenu implements Message {
    REGISTER_STATION("1", StationManager::register),
    DELETE_LINE("2", StationManager::delete),
    PRINT_STATION("3", OutputView::printStations);

    private final String input;
    private final Runnable handler;

    StationMenu(String input, Runnable handler) {
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
