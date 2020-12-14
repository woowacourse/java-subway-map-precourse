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
import subway.view.InputView;

public class MainMenu {
    private static final String MAIN_TITLE = CommonMessage.SHARP + CommonMessage.SHARP + CommonMessage.SPACE
            + CategoryType.MAIN + CommonMessage.SPACE + CommonMessage.SCREEN;
    private static final char STATION_SEL = '1';
    private static final char LINE_SEL = '2';
    private static final char SECTION_SEL = '3';
    private static final char PRINT_STATION_LINE_SEL = '4';
    private static final char QUIT_SEL = 'Q';
    private static final String QUIT = "종료";
    private InputView inputView;

    private List<Character> selMenu;
    private List<SubMenu> subMenuList;

    public MainMenu(Scanner scanner, InputView inputView) {
        selMenu = Arrays.asList(STATION_SEL, LINE_SEL, SECTION_SEL, PRINT_STATION_LINE_SEL, QUIT_SEL);
        subMenuList = Arrays.asList(new StationMenu(STATION_SEL, CategoryType.STATION, scanner),
                new LineMenu(LINE_SEL, CategoryType.LINE, scanner),
                new SectionMenu(SECTION_SEL, CategoryType.SECTION, scanner),
                new StationLineMenu(PRINT_STATION_LINE_SEL, CategoryType.STATION_LINE, scanner));
        this.inputView = inputView;
    }

    public void runMainMenu() {
        while (true) {
            printMainMenu();
            char sel = requestInputMainMenu();

            if (sel == QUIT_SEL) {
                break;
            }
            subMenuList.stream().filter(menu -> sel == menu.getOrder()).findFirst().get().runSubMenu();
        }
    }

    private void printMainMenu() {
        System.out.println(MAIN_TITLE);
        subMenuList.stream().forEach(menu -> System.out.println(menu.getTitleActionMessage()));
        System.out.println(QUIT_SEL + CommonMessage.PUNCTUATION + CommonMessage.SPACE + QUIT);
        System.out.println();
    }

    private char requestInputMainMenu() {
        return inputView.inputMainMenu(selMenu);
    }
}
