package subway.view;

import subway.enums.SectionMenu;

import java.util.Arrays;
import java.util.List;

public class SectionView {

    public static void printSectionMenu() {
        SectionMenu[] sectionMenu = SectionMenu.values();
        List<SectionMenu> menu = Arrays.asList(sectionMenu);
        menu.stream().map(SectionMenu::getTitle).forEach(System.out::println);
        System.out.println();
    }
}
