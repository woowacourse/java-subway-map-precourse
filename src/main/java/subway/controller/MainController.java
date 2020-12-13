package subway.controller;

import subway.domain.function.Functionable;
import subway.domain.function.MainFunction;

public final class MainController {

    public void run() {

        boolean quit = false;

        ManagementController managementController = ManagementController.initialize();

        while (!quit) {
            managementController = Functionable
                    .function(managementController, MainFunction.TITLE, MainFunction.values());

            if (managementController == null) {
                quit = true;
            }
        }
    }
}
