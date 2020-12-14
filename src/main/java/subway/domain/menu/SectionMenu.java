package subway.domain.menu;

import subway.controller.section.SectionFunction;
import subway.domain.exception.NoSuchMenuException;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;


public enum SectionMenu {
    ADD("1", SectionFunction::add),
    DELETE("2", SectionFunction::delete),
    BACK("B", null);

    private final String button;
    private final Function function;

    SectionMenu(String button, Function<Object, Object> function) {
        this.button = button;
        this.function = function;
    }

    public static boolean isRunning(SectionMenu sectionMenu) {
        return !Objects.equals(sectionMenu, SectionMenu.BACK);
    }

    public boolean equals(String button) {
        return Objects.equals(this.button, button);
    }

    public static SectionMenu findMenu(String inputMenu) {
        return Arrays.stream(SectionMenu.values())
                .filter(menu -> menu.equals(inputMenu))
                .findAny()
                .orElseThrow(() -> new NoSuchMenuException());
    }

    public void runFunction(Object object) {
        function.apply(new Object());
    }
}
