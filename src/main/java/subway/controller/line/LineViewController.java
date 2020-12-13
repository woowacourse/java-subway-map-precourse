package subway.controller.line;

import subway.controller.Controller;
import subway.domain.line.LineRepository;
import subway.view.OutputView;

public class LineViewController implements Controller {

    @Override
    public void run() {
        OutputView.printLines(LineRepository.lines());
    }
}
