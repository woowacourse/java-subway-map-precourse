package subway.controller;

import subway.domain.function.Functionable;
import subway.domain.function.MainFunction;
import subway.exception.SubwayRuntimeException;

public final class MainController {

    public static final String LINE_FEED = "\n";

    public void run() {
        ManagementController managementController = ManagementController.initialize();

        while (isProgressing(managementController)) {
            try {
                managementController = Functionable
                        .function(managementController, MainFunction.TITLE, MainFunction.values());
            } catch (SubwayRuntimeException e) {
                System.out.println(e.getMessage() + LINE_FEED);
            }
        }
    }

    private boolean isProgressing(ManagementController managementController) {
        return managementController != null;
    }
}
