package subway.manager.menu;

import subway.controller.StationController;
import subway.view.Output;
import java.util.Arrays;
import java.util.function.Consumer;

public enum StationMenu {
    ADD("1", "1. 역 등록", StationController::save),
    REMOVE("2", "2. 역 삭제", StationController::remove),
    MANAGEMENT("3", "3. 역 조회", StationController::getList),
    BACK("B", "B. 돌아가기", (StationController) -> goBack());

    private static final String menu = "## 역 관리 화면";
    private static boolean back = true;
    private String number;
    private String name;
    private Consumer<StationController> nextAction;

    StationMenu(String number, String name, Consumer<StationController> nextAction) {
        this.number = number;
        this.name = name;
        this.nextAction = nextAction;
    }

    public static void printMenu() {
        Output.print(menu);
        Arrays.stream(StationMenu.values())
                .forEach(System.out::println);
    }

    public static StationMenu getStationMenuType(String selectMenu) {
        return Arrays.stream(StationMenu.values())
                .filter(stationMenu -> stationMenu.number.equals(selectMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다."));
    }

    public void execute(StationController stationController) {
        nextAction.accept(stationController);
    }

    private static void goBack() {
        back = false;
    }

    public static boolean isBack() {
        return back;
    }

    @Override
    public String toString() {
        return name;
    }
}
