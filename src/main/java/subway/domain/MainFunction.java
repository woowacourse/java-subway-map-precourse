package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum MainFunction {
    STATION("1", "역 관리", StationFunction::perform),
    LINE("2", "노선 관리", LineFunction::perform),
    RANGE("3", "구간 관리", RangeFunction::perform),
    SUBWAY_MAP("4", "지하철 노선도 출력", Function.identity()),
    QUIT("Q", "종료", null);

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    MainFunction(String identifier, String description,
                 Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    public static ManageController perform(ManageController manageController) {
        OutputView.printView(MainFunction.values());

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(MainFunction.values())
                .filter(function -> function.identifier.equals(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(manageController);
    }
}
