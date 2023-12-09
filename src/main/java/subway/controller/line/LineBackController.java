package subway.controller.line;

import subway.view.InputView;
import subway.view.OutputView;

public class LineBackController implements SubLineController {
    @Override
    public LineOption process() {
        return LineOption.BACK;
    }
}
