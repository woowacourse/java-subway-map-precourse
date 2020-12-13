package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum RangeFunction {
    ADD("1", ManageController::addRange),
    REMOVE("2", ManageController::removeRange),
    BACK("B", Function.identity());

    private final String functionIndex;

    private final Function<ManageController, ManageController> function;

    RangeFunction(String functionIndex,
                  Function<ManageController, ManageController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static ManageController perform(ManageController lineController) {
        OutputView.printView(RangeFunction.values());

        String functionIndex = InputView.inputFunctionIdentifier();

        return Arrays.stream(RangeFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
