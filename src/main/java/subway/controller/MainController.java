package subway.controller;

import subway.domain.function.Functionable;
import subway.domain.function.MainFunction;

public final class MainController {

    public void run() {
        ManagementController managementController = ManagementController.initialize();

        while (isProgressing(managementController)) {
            managementController = Functionable
                    .function(managementController, MainFunction.TITLE, MainFunction.values());
        }
    }

    private boolean isProgressing(ManagementController managementController) {
        return managementController != null;
    }
}
