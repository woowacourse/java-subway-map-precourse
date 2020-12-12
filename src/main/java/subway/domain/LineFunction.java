package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

public enum LineFunction {
    ADD("1", LineController::addLine),
    REMOVE("2", LineController::removeLine),
    LOAD("3", LineController::loadLines),
    BACK("B", Function.identity());

    private final String functionIndex;

    private final Function<LineController, LineController> function;

    LineFunction(String functionIndex,
                    Function<LineController, LineController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static LineController perform(String functionIndex,
                                            LineController lineController) {
        return Arrays.stream(LineFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
