package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum StationFunction {
    ADD("1", StationController::add),
    REMOVE("2", StationController::remove),
    LOAD("3", StationController::load),
    BACK("B", Function.identity());

    private final String functionIndex;

    private final Function<StationController, StationController> function;

    StationFunction(String functionIndex,
                    Function<StationController, StationController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static StationController perform(String functionIndex,
                                            StationController stationController) {
        return Arrays.stream(StationFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(stationController);
    }
}
