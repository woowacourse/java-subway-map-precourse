package subway.domain.menu;

import subway.controller.line.LineFunction;
import subway.domain.LineRepository;
import subway.domain.exception.NoSuchMenuException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public enum LineMenu {
    ADD("1", LineFunction::add),
    DELETE("2", LineFunction::delete),
    PRINT_ALL("3", LineFunction::printAll),
    BACK("B", null);

    private final String button;
    private final Function function;

    LineMenu(String button, Function<LineRepository, LineRepository> function) {
        this.button = button;
        this.function = function;
    }

    public boolean equals(String button) {
        return Objects.equals(this.button, button);
    }

    public static boolean isRunning(LineMenu lineMenu) {
        return !Objects.equals(lineMenu, LineMenu.BACK);
    }

    public static LineMenu findMenu(String inputMenu) {
        return Arrays.stream(LineMenu.values())
                .filter(menu -> menu.equals(inputMenu))
                .findAny()
                .orElseThrow(() -> new NoSuchMenuException());
    }

    public void runFunction(LineRepository lineRepository) {
        function.apply(lineRepository);
    }
}
