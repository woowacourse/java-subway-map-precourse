package subway.controller.line;

import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineRemoveController implements SubLineController {
    private final InputView inputView;
    private final OutputView outputView;

    public LineRemoveController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public LineOption process() {
        String LineName = inputView.readRemoveLine();
        if (!LineRepository.containsLineName(LineName)) {
            throw new IllegalArgumentException("존재하지 않는 노선입니다.");
        }
        LineRepository.deleteLineByName(LineName);
        outputView.printRemoveLine();
        return LineOption.DELETE;
    }
}
