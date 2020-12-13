package subway.domain;

import subway.domain.function.Functionable;
import subway.domain.function.MainFunction;

public class MainController {

    public void run() {

        boolean quit = false;

        ManageController manageController = new ManageController();

        while (!quit) {
            manageController = Functionable
                    .function(manageController, MainFunction.TITLE, MainFunction.values());

            if (manageController == null) {
                quit = true;
            }
        }
    }
}
