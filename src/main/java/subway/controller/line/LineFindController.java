package subway.controller.line;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.OutputView;

public class LineFindController implements SubLineController {
    private final OutputView outputView;

    public LineFindController(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public LineOption process() {
        List<Line> lines = LineRepository.lines();
        outputView.printAllLine(lines);
        return LineOption.LIST;
    }
}
