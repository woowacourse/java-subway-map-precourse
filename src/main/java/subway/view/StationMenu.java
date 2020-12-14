package subway.view;

import subway.controller.StationController;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public enum StationMenu {
    ADD("1", "1. 역 등록", StationController::save),
    REMOVE("2", "2. 역 삭제", StationController::remove),
    MANAGEMENT("3", "3. 역 관리", StationController::getList),
    BACK("B", "B. 돌아가기", (StationController -> {}));

    private String number;
    private String name;
    private Consumer<StationController> nextAction;
    private static boolean gameExit = true;

    StationMenu(String number, String name, Consumer<StationController> nextAction) {
        this.number = number;
        this.name = name;
        this.nextAction = nextAction;
    }

    public static void printMenu(Scanner scanner) {
        System.out.println("## 역 관리 화면");
        Arrays.stream(StationMenu.values())
                .forEach(System.out::println);
        Output.printNewLine();
    }

    @Override
    public String toString() {
        return name;
    }
}
