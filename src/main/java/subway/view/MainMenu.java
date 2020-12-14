package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public enum MainMenu {
    STATION_MENU("1", "1. 역 관리", StationMenu::printMenu),
    LINE_MENU("2", "2. 노선 관리", LineMenu::printMenu),
    SECTION_MENU("3", "3. 구간 관리", SectionMenu::printMenu),
    ROUTE_MAP_MENU("4", "4. 지하철 노선도 출력", RouteMapMenu::printMenu),
    EXIT("5", "5. 종료", MainMenu::exitGame);

    private String number;
    private String name;
    private Consumer<Scanner> selectMenu;
    private static boolean gameExit = true;

    MainMenu(String number, String name, Consumer<Scanner> selectMenu) {
        this.number = number;
        this.name = name;
        this.selectMenu = selectMenu;
    }

    private static void exitGame(Scanner scanner) {
        gameExit = false;
    }

    public static void printMenu() {
        System.out.println("## 메인 화면");
        Arrays.stream(MainMenu.values())
                .forEach(System.out::println);
        System.out.println();
    }

    public boolean isExit() {
        return gameExit;
    }
}
