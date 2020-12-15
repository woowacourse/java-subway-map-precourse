package subway.manager.menu;

import subway.controller.LineController;
import subway.view.Output;
import java.util.Arrays;
import java.util.function.Consumer;

public enum LineMenu {
    ADD("1", "1. 노선 등록", LineController::save),
    REMOVE("2", "2. 노선 삭제", LineController::remove),
    MANAGEMENT("3", "3. 노선 조회", LineController::getList),
    BACK("B", "B. 돌아가기", (LineController) -> LineMenu.goBackMenu());

    private static final String menu = "## 노선 관리 화면";
    private static boolean restart = true;
    private String number;
    private String name;
    private Consumer<LineController> nextAction;


    LineMenu(String number, String name, Consumer<LineController> nextAction) {
        this.number = number;
        this.name = name;
        this.nextAction = nextAction;
    }

    public static void printMenu() {
        Output.print(menu);
        Arrays.stream(LineMenu.values())
                .forEach(System.out::println);
    }

    public static LineMenu getLineMenuType(String selectMenu) {
        return Arrays.stream(LineMenu.values())
                .filter(lineMenu -> lineMenu.number.equals(selectMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public void execute(LineController lineController) {
        nextAction.accept(lineController);
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
