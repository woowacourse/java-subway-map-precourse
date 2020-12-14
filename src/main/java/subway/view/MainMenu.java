package subway.view;

import subway.manager.LineManager;
import subway.manager.RouteMapManager;
import subway.manager.StationManager;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public enum MainMenu {
    STATION_MENU("1", "1. 역 관리", StationManager::run),
    LINE_MENU("2", "2. 노선 관리", LineManager::run),
    SECTION_MENU("3", "3. 구간 관리", StationManager::run),
    ROUTE_MAP_MENU("4", "4. 지하철 노선도 출력", RouteMapManager::run),
    EXIT("Q", "Q. 종료", (scanner) -> exitGame());

    private String number;
    private String name;
    private Consumer<Scanner> nextAction;
    private static boolean gameExit = true;

    MainMenu(String number, String name, Consumer<Scanner> nextAction) {
        this.number = number;
        this.name = name;
        this.nextAction = nextAction;
    }

    public static void printMenu() {
        System.out.println("## 메인 화면");
        Arrays.stream(MainMenu.values())
                .forEach(System.out::println);
        Output.printNewLine();
    }

    public static MainMenu getMainMenuType(String selectMenu) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.number.equals(selectMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    private static void exitGame() {
        gameExit = false;
    }

    public void execute(Scanner scanner) {
        nextAction.accept(scanner);
    }

    public boolean isExit() {
        return gameExit;
    }

    @Override
    public String toString() {
        return name;
    }
}
