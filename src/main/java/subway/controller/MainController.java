package subway.controller;

import subway.domain.menu.MainMenu;
import subway.domain.menu.Menu;

public final class MainController {

    public void run() {
        ManagementController managementController = ManagementInitializer.initialize();

        while (isProgressing(managementController)) {
            managementController =
                    Menu.function(managementController, MainMenu.TITLE, MainMenu.values());
        }
    }

    private boolean isProgressing(ManagementController managementController) {
        return managementController != null;
    }
}
