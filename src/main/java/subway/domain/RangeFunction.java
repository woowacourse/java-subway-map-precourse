package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum RangeFunction {
    ADD("1", "구간 등록", ManageController::addRange),
    REMOVE("2", "구간 삭제", ManageController::removeRange),
    BACK("B", "돌아가기", Function.identity());

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    RangeFunction(String identifier, String description,
                  Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    public static ManageController perform(ManageController lineController) {
        OutputView.printView(RangeFunction.values());

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(RangeFunction.values())
                .filter(function -> function.identifier.equals(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(lineController);
    }
}
