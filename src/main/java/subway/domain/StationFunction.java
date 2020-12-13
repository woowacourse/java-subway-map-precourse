package subway.domain;

import java.util.Arrays;
import java.util.function.Function;

import subway.view.InputView;
import subway.view.OutputView;

public enum StationFunction {
    ADD("1", "역 등록", ManageController::addStation),
    REMOVE("2", "역 삭제", ManageController::removeStation),
    LOAD("3", "역 조회", ManageController::loadStations),
    BACK("B", "돌아가기", Function.identity());

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    StationFunction(String identifier, String description,
                    Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    public static ManageController perform(ManageController stationController) {
        OutputView.printView(StationFunction.values());

        String identifier = InputView.inputFunctionIdentifier();

        return Arrays.stream(StationFunction.values())
                .filter(function -> function.identifier.equals(identifier))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."))
                .function
                .apply(stationController);
    }
}
