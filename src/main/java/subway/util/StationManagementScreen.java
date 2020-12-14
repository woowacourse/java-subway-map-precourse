package subway.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import subway.controller.StationController;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

public enum StationManagementScreen {
    REGISTER_STATION("1", (inputView) -> {
        String stationName = inputView.getName(OutputView.ORDER_TO_REGISTER_STATION);
        return StationController.registerStation(stationName);
    }),
    DELETE_STATION("2", (inputView) -> {
        String stationName = inputView.getName(OutputView.ORDER_TO_DELETE_STATION);
        return StationController.deleteStation(stationName);
    }),
    SEARCH_STATION("3", (inputView) -> {
        List<Station> stations = StationController.searchStation();
        OutputView.print(OutputView.STATION_LIST);
        OutputView.printList(stations);
        return false;
    }),
    BACK("B", (inputView) -> false);

    private String feature;
    private Function<InputView, Boolean> function;

    StationManagementScreen(String feature, Function<InputView, Boolean> function) {
        this.feature = feature;
        this.function = function;
    }

    public static boolean run(InputView inputView, String command) {
        if (hasFeature(command)) {
            return Arrays.stream(values())
                .filter(stationManagementScreen -> stationManagementScreen.feature.equals(command))
                .findAny()
                .orElse(StationManagementScreen.BACK)
                .function.apply(inputView);
        }
        return true;
    }

    public static boolean hasFeature(String command) {
        return Arrays.stream(values())
            .anyMatch(stationManagementScreen -> stationManagementScreen.feature.equals(command));
    }

}
