package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum RangeFunction {
    ADD("1", LineController::addRange),
    REMOVE("2", LineController::removeRange),
    BACK("B", Function.identity());

    private final String functionIndex;

    private final Function<LineController, LineController> function;

    RangeFunction(String functionIndex,
                  Function<LineController, LineController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static LineController perform(String functionIndex,
                                         LineController lineController) {
        return Arrays.stream(RangeFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
