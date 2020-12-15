package subway.controller.line;

import subway.controller.Controller;
import subway.view.OutputView;

public class LineViewController implements Controller {

    @Override
    public void run() {
        OutputView.printLines();
    }
}
