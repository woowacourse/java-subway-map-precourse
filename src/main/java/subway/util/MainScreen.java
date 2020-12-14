package subway.util;

import java.util.Arrays;
import java.util.function.Supplier;
import subway.Router;
import subway.controller.LineController;
import subway.view.OutputView;

public enum MainScreen {
    STATION_MANAGEMENT("1", Router::enterStationManagementScreen),
    LINE_MANAGEMENT("2", Router::enterLineManagementScreen),
    SECTION_MANAGEMENT("3", Router::enterSectionManagementScreen),
    ROUTE_MAP_PRINT("4", () -> OutputView.printMap(LineController.searchLine())),
    QUIT("Q", () -> false);

    private String number;
    private Supplier<Boolean> function;


    MainScreen(String number, Supplier<Boolean> function) {
        this.number = number;
        this.function = function;
    }

    public static boolean run(String command) {
        if(hasNumber(command)){
            return Arrays.stream(values())
                .filter(mainScreen -> mainScreen.number.equals(command))
                .findAny()
                .get()
                .function.get();
        }
        return true;
    }

    public static boolean hasNumber(String command) {
        return Arrays.stream(values())
            .anyMatch(mainScreen -> mainScreen.number.equals(command));
    }
}