package subway.domain.menu;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum MainMenu implements Menu {
    STATION(MenuIdentifier.ONE, MenuName.STATION_MANAGEMENT, managementController -> Menu
            .function(managementController, MenuName.STATION_MANAGEMENT, StationMenu.values())),

    LINE(MenuIdentifier.TWO, MenuName.LINE_MANAGEMENT, managementController -> Menu
            .function(managementController, MenuName.LINE_MANAGEMENT, LineMenu.values())),

    SECTION(MenuIdentifier.THREE, MenuName.SECTION_MANAGEMENT, managementController -> Menu
            .function(managementController, MenuName.SECTION_MANAGEMENT, SectionMenu.values())),

    SUBWAY_MAP(MenuIdentifier.FOUR, MenuName.LOAD_SUBWAY_MAP, ManagementController::loadSubwayMap),

    QUIT(MenuIdentifier.QUIT, MenuName.QUIT, managementController -> null);

    public static final String TITLE = "메인";

    private final String identifier;

    private final String name;

    private final Function<ManagementController, ManagementController> function;

    MainMenu(final String identifier, final String name,
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
