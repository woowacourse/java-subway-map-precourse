package subway.domain.function;

import java.util.function.Function;

import subway.domain.ManageController;

public enum LineFunction implements Functionable {
    ADD("1", "노선 등록", ManageController::addLine),
    REMOVE("2", "노선 삭제", ManageController::removeLine),
    LOAD("3", "노선 조회", ManageController::loadLines),
    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "노선 관리";

    private final String identifier;

    private final String description;

    private final Function<ManageController, ManageController> function;

    LineFunction(String identifier, String description,
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
