package subway.domain.menu;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum LineMenu implements Menu {
    ADD(MenuIdentifier.ONE, MenuName.ADD_LINE, ManagementController::addLine),
    REMOVE(MenuIdentifier.TWO, MenuName.REMOVE_LINE, ManagementController::removeLine),
    LOAD(MenuIdentifier.THREE, MenuName.LOAD_LINE, ManagementController::loadLines),
    BACK(MenuIdentifier.BACK, MenuName.BACK, Function.identity());

    private final String identifier;

    private final String name;

    private final Function<ManagementController, ManagementController> function;

    LineMenu(final String identifier, final String name,
             final Function<ManagementController, ManagementController> function) {
        this.identifier = identifier;
        this.name = name;
        this.function = function;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getName() {
        return name;
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
