package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum LineFunction {
    ADD("1", ManageController::addLine),
    REMOVE("2", ManageController::removeLine),
    LOAD("3", ManageController::loadLines),
    BACK("B", Function.identity());

    private final String functionIndex;

    private final Function<ManageController, ManageController> function;

    LineFunction(String functionIndex,
                 Function<ManageController, ManageController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static ManageController perform(ManageController lineController) {
        OutputView.printView(LineFunction.values());

        String functionIndex = InputView.inputFunctionIdentifier();

        return Arrays.stream(LineFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
