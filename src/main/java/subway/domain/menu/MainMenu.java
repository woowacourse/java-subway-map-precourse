package subway.domain.menu;

import java.util.function.Function;

import subway.controller.ManagementController;

public enum MainMenu implements Menu {
    STATION("1", StationMenu.TITLE, managementController -> Menu
            .function(managementController, StationMenu.TITLE, StationMenu.values())),

    LINE("2", LineMenu.TITLE, managementController -> Menu
            .function(managementController, LineMenu.TITLE, LineMenu.values())),

    SECTION("3", SectionMenu.TITLE, managementController -> Menu
            .function(managementController, SectionMenu.TITLE, SectionMenu.values())),

    SUBWAY_MAP("4", "지하철 노선도 출력", ManagementController::loadSubwayMap),

    QUIT("Q", "종료", managementController -> null);

    public static final String TITLE = "메인";

    private final String identifier;

    private final String description;

    private final Function<ManagementController, ManagementController> function;

    MainMenu(final String identifier, final String description,
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
