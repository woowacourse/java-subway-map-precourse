package subway.domain.menu;

import subway.controller.station.StationFunction;
import subway.domain.exception.NoSuchMenuException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public enum StationMenu {
    ADD("1", () -> StationFunction.add()),
    DELETE("2", () -> StationFunction.delete()),
    PRINT_ALL("3", () -> StationFunction.printAll()),
    BACK("B", null);

    private final String button;
    private final Supplier function;

    StationMenu(String button, Supplier function) {
        this.button = button;
        this.function = function;
    }

    public static boolean isRunning(StationMenu stationMenu) {
        return !Objects.equals(stationMenu, StationMenu.BACK);
    }

    public static StationMenu findMenu(String inputMenu) {
        return Arrays.stream(StationMenu.values())
                .filter(menu -> menu.equals(inputMenu))
                .findAny()
                .orElseThrow(() -> new NoSuchMenuException());
    }

    public boolean equals(String button) {
        return Objects.equals(this.button, button);
    }

    public void runFunction() {
        function.get();
    }
}
