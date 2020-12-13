package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum LineFunction {
    ADD("1", "노선 등록", ManageController::addLine),
    REMOVE("2", "노선 삭제", ManageController::removeLine),
    LOAD("3", "노선 조회", ManageController::loadLines),
    BACK("B", "돌아가기", Function.identity());

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    LineFunction(String identifier, String description,
                 Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
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
