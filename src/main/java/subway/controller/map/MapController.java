package subway.controller.map;

import subway.controller.Controller;
import subway.view.InputView;
import subway.view.OutputView;

public class MapController implements Controller {

    @Override
    public void run() {
        try {
            OutputView.printMap();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
