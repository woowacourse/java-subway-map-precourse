package subway.manager.menu;

import subway.controller.SectionController;
import subway.view.Output;

import java.util.Arrays;
import java.util.function.Consumer;

public enum SectionMenu {
    ADD("1", "1. 구간 등록", SectionController::save),
    REMOVE("2", "2. 구간 삭제", SectionController::remove),
    BACK("B", "B. 돌아가기", (sectionController) -> SectionMenu.goBackMenu());

    private static final String menu = "## 구간 관리 화면";
    private static boolean restart = true;
    private String number;
    private String name;
    private Consumer<SectionController> nextAction;

    SectionMenu(String number, String name, Consumer<SectionController> nextAction) {
        this.number = number;
        this.name = name;
        this.nextAction = nextAction;
    }

    public static void printMenu() {
        Output.print(menu);
        Arrays.stream(SectionMenu.values())
                .forEach(System.out::println);
    }

    public static void initMenuStatus() {
        restart = true;
    }

    private static void goBackMenu() {
        restart = false;
    }

    public static boolean isRestart() {
        return restart;
    }

    @Override
    public String toString() {
        return name;
    }
}
