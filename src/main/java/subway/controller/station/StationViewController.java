package subway.controller.station;

import subway.controller.Controller;
import subway.view.OutputView;

public class StationViewController implements Controller {

    @Override
    public void run() {
        OutputView.printStations();
    }
}
