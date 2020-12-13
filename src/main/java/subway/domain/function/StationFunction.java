package subway.domain.function;

import java.util.function.Function;

import subway.controller.ManageController;
import subway.view.InputView;

public enum StationFunction implements Functionable {
    ADD("1", "역 등록",
            manageController -> manageController.addStation(InputView.inputStation())),

    REMOVE("2", "역 삭제",
            manageController -> manageController.removeStation(InputView.inputStation())),

    LOAD("3", "역 조회", ManageController::loadStations),

    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "역 관리";

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    StationFunction(final String identifier, final String description,
                    final Function<ManageController, ManageController> function) {
        this.identifier = identifier;
        this.description = description;
        this.function = function;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Function<ManageController, ManageController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}
