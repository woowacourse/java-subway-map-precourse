package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum MainFunction {
    STATION("1", StationFunction::perform),
    LINE("2", LineFunction::perform),
    RANGE("3", RangeFunction::perform),
    SUBWAY_MAP("4", Function.identity()),
    QUIT("Q", null);

    private final String functionIndex;

    private final Function<ManageController, ManageController> function;

    MainFunction(String functionIndex,
                 Function<ManageController, ManageController> function) {
        this.functionIndex = functionIndex;
        this.function = function;
    }

    public static ManageController perform(ManageController manageController) {
        OutputView.printView(MainFunction.values());

        String functionIndex = InputView.inputFunctionIdentifier();

        return Arrays.stream(MainFunction.values())
                .filter(function -> function.functionIndex.equals(functionIndex))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(manageController);
    }
}
