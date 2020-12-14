package subway.domain.menu;

import subway.controller.section.SectionFunction;

import java.util.Objects;
import java.util.function.Function;

public enum SectionMenu {
//    ADD("1", SectionFunction::add),
//    DELETE("2", SectionFunction::delete),
    BACK("B", null);

    private final String button;
    private final Function function;

    SectionMenu(String button, Function function) {
        this.button = button;
        this.function = function;
    }

    public static boolean isRunning(SectionMenu sectionMenu) {
        return !Objects.equals(sectionMenu, SectionMenu.BACK);
    }
}
