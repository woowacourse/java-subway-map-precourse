package subway.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import subway.domain.menu.constant.CategoryType;
import subway.domain.menu.constant.CommonMessage;
import subway.domain.menu.submenu.LineMenu;
import subway.domain.menu.submenu.SectionMenu;
import subway.domain.menu.submenu.StationLineMenu;
import subway.domain.menu.submenu.StationMenu;
import subway.domain.menu.submenu.SubMenu;

public class MainMenu {
    private static final String MAIN_TITLE = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE
            + CategoryType.MAIN + CommonMessage.SPACE + CommonMessage.SCREEN;
    private static final char STATION_SEL = '1';
    private static final char LINE_SEL = '2';
    private static final char SECTION_SEL = '3';
    private static final char PRINT_STATION_LINE_SEL = '4';
    private static final char QUIT_SEL = 'Q';
    private static final String QUIT = "종료";
    private final Scanner scanner;

    List<SubMenu> subMenuList;

    public MainMenu(Scanner scanner) {
        subMenuList = Arrays.asList(new StationMenu(STATION_SEL, CategoryType.STATION),
                new LineMenu(LINE_SEL, CategoryType.LINE), new SectionMenu(SECTION_SEL, CategoryType.SECTION),
                new StationLineMenu(PRINT_STATION_LINE_SEL, CategoryType.STATION_LINE), new SubMenu(QUIT, QUIT_SEL));
        this.scanner = scanner;
    }

    public void runMainMenu() {
        while (true) {
            printMainMenu();
            char sel = inputMainMenu();

            if (sel == QUIT_SEL) {
                break;
            }
            subMenuList.stream().filter(menu -> sel == menu.getOrder()).findFirst().get().action();
        }
    }

    private void printMainMenu() {
        System.out.println(MAIN_TITLE);
        subMenuList.stream().forEach(menu -> System.out.println(menu.getTitleActionMessage()));
        System.out.println();
    }

    private char inputMainMenu() {
        System.out.println(CommonMessage.SELECT_MESSAGE);
        char sel = scanner.nextLine().charAt(0);

        return sel;
    }

}
