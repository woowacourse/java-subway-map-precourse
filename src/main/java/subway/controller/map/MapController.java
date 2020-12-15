package subway.controller.map;

import subway.controller.Controller;
import subway.view.OutputView;

public class MapController implements Controller {

    @Override
    public void run() {
        OutputView.printMap();
    }
}
