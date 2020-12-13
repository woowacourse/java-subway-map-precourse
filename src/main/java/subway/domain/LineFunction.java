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

    private final String identifier;

    private final Function<ManageController, ManageController> function;

    LineFunction(String identifier,
                 Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.function = function;
    }

    public static ManageController perform(ManageController lineController) {
        OutputView.printView(LineFunction.values());

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(LineFunction.values())
                .filter(function -> function.identifier.equals(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
