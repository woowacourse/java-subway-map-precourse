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
    ROUTE_MAP_PRINT("4", () -> {
        OutputView.printMap(LineController.searchLine());
        return true;
    }),
    QUIT("Q", () -> false);

    private String feature;
    private Supplier<Boolean> function;

    MainScreen(String feature, Supplier<Boolean> function) {
        this.feature = feature;
        this.function = function;
    }

    public static boolean run(String command) {
        if (hasFeature(command)) {
            return Arrays.stream(values())
                .filter(mainScreen -> mainScreen.feature.equals(command))
                .findAny()
                .orElse(MainScreen.QUIT)
                .function.get();
        }
        return true;
    }

    public static boolean hasFeature(String command) {
        return Arrays.stream(values())
            .anyMatch(mainScreen -> mainScreen.feature.equals(command));
    }
}