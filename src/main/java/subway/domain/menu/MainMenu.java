package subway.domain.menu;

import subway.controller.*;
import subway.controller.line.LineController;
import subway.controller.section.SectionController;
import subway.controller.station.StationController;
import subway.domain.exception.NoSuchMenuException;

import java.util.Arrays;
import java.util.Objects;

public enum MainMenu {
    STATION("1", new StationController()),
    LINE("2", new LineController()),
    SECTION("3", new SectionController()),
    PRINT_ALL("4", new MainController()),
    EXIT("Q", null);

    private String button;
    private Controller controller;

    MainMenu(String value, Controller controller) {
        this.button = value;
        this.controller = controller;
    }

    public static boolean isRunning(MainMenu menu) {
        return !Objects.equals(menu, MainMenu.EXIT);
    }

    public Controller getController() {
        return controller;
    }

    private boolean equals(String value) {
        return Objects.equals(this.button, value);
    }

    public static MainMenu findMenu(String inputMenu) {
        return Arrays.stream(MainMenu.values())
                .filter(menu -> menu.equals(inputMenu))
                .findAny()
                .orElseThrow(() -> new NoSuchMenuException());
    }
}
