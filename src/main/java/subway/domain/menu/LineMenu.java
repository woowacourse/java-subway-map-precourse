package subway.domain.menu;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum LineMenu implements Menu {
    ADD("1", "노선 등록", ManagementController::addLine),
    REMOVE("2", "노선 삭제", ManagementController::removeLine),
    LOAD("3", "노선 조회", ManagementController::loadLines),
    BACK("B", "돌아가기", Function.identity());

    public static final String TITLE = "노선 관리";

    private final String identifier;

    private final String description;

    private final Function<ManagementController, ManagementController> function;

    LineMenu(final String identifier, final String description,
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
