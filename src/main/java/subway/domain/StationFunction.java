package subway.domain;

import java.util.function.Function;

public enum StationFunction implements Functionable {
    ADD("1", "역 등록", ManageController::addStation),
    REMOVE("2", "역 삭제", ManageController::removeStation),
    LOAD("3", "역 조회", ManageController::loadStations),
    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "역 관리";

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    StationFunction(String identifier, String description,
                    Function<ManageController, ManageController> function) {
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
