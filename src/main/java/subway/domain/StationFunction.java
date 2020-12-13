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

    private final String functionIndex;

    private final Function<ManageController, ManageController> function;

    StationFunction(String functionIndex,
                    Function<ManageController, ManageController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static ManageController perform(ManageController stationController) {
        OutputView.printView(StationFunction.values());

        String functionIndex = InputView.inputFunctionIdentifier();

        return Arrays.stream(StationFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(stationController);
    }
}
