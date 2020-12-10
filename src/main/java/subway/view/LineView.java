package subway.view;

import subway.enums.LineMenu;

import java.util.Arrays;
import java.util.List;

public class LineView {

    public static void printLineMenu() {
        LineMenu[] lineMenu = LineMenu.values();
        List<LineMenu> menu = Arrays.asList(lineMenu);
        menu.stream().map(LineMenu::getTitle).limit(LineMenu.BACK.ordinal()).forEach(System.out::println);
        System.out.println();
    }
}
