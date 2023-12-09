package subway.controller.line;

import java.util.List;
import subway.controller.SubController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.OutputView;

public class LineFindController implements SubController {
    private final OutputView outputView;

    public LineFindController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void process() {
        List<Line> lines = LineRepository.lines();
        outputView.printAllLine(lines);
    }
}
