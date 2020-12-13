package subway.domain.function;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum StationFunction implements Functionable {
    ADD("1", "역 등록", ManagementController::addStation),
    REMOVE("2", "역 삭제", ManagementController::removeStation),
    LOAD("3", "역 조회", ManagementController::loadStations),
    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "역 관리";

    private final String identifier;

    private final String description;

    private final Function<ManagementController, ManagementController> function;

    StationFunction(final String identifier, final String description,
                    final Function<ManagementController, ManagementController> function) {
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
    public Function<ManagementController, ManagementController> getFunction() {
        return function;
    }

    @Override
    public boolean equalsIdentifier(String identifier) {
        return this.identifier.equals(identifier);
    }
}
