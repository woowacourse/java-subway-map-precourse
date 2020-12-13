package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum StationFunction {
    ADD("1", ManageController::addStation),
    REMOVE("2", ManageController::removeStation),
    LOAD("3", ManageController::loadStations),
    BACK("B", Function.identity());

    private final String identifier;

    private final Function<ManageController, ManageController> function;

    StationFunction(String identifier,
                    Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.function = function;
    }

    public static ManageController perform(ManageController stationController) {
        OutputView.printView(StationFunction.values());

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(StationFunction.values())
                .filter(function -> function.identifier.equals(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(stationController);
    }
}
