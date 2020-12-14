package subway.util;

import java.util.Arrays;
import java.util.function.Function;
import subway.controller.LineController;
import subway.view.InputView;
import subway.view.OutputView;

public enum SectionManagementScreen {
    REGISTER_SECTION("1", (inputView) -> {
        String lineName = inputView.getName(OutputView.ORDER_TO_ENTER_LINE);
        String stationName = inputView.getName(OutputView.ORDER_TO_ENTER_STATION);
        int sequence = inputView.getSequence(OutputView.ORDER_TO_ENTER_SEQUENCE);
        return LineController.registerSection(lineName, stationName, sequence);
    }),
    DELETE_SECTION("2", (inputView) -> {
        String lineName = inputView.getName(OutputView.ORDER_TO_ENTER_LINE_TO_DELETE);
        String stationName = inputView.getName(OutputView.ORDER_TO_ENTER_STATION_TO_DELETE);
        return LineController.deleteSection(lineName, stationName);
    }),
    BACK("B", (inputView) -> false);

    private String feature;
    private Function<InputView, Boolean> function;

    SectionManagementScreen(String feature,
        Function<InputView, Boolean> function) {
        this.feature = feature;
        this.function = function;
    }

    public static boolean run(InputView inputView, String command) {
        if (hasFeature(command)) {
            return Arrays.stream(values())
                .filter(sectionManagementScreen -> sectionManagementScreen.feature.equals(command))
                .findAny()
                .orElse(SectionManagementScreen.BACK)
                .function.apply(inputView);
        }
        return true;
    }

    public static boolean hasFeature(String command) {
        return Arrays.stream(values())
            .anyMatch(sectionManagementScreen -> sectionManagementScreen.feature.equals(command));
    }
}
