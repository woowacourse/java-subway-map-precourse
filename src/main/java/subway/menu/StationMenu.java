package subway.menu;

import static subway.view.TextFixtures.WRONG_MENU_INPUT_EXCEPTION_MESSAGE;

import java.util.Arrays;
import subway.controller.manager.StationManager;
import subway.exception.SubwayCustomException;
import subway.view.OutputView;

public enum StationMenu {
    ADD_STATION("1", StationManager::addStation),
    DELETE_STATION("2", StationManager::deleteStation),
    SHOW_STATION_LIST("3", OutputView::showStationList),
    GO_BACK("B", () -> {
    });

    private final String input;
    private final Runnable handler;

    StationMenu(String input, Runnable handler) {
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
