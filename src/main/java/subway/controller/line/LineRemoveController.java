package subway.controller.line;

import static subway.exception.ExceptionMessage.NOT_FOUND_LINE;

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
        try {
            String LineName = inputView.readRemoveLine();
            if (!LineRepository.containsLineName(LineName)) {
                throw new IllegalArgumentException(NOT_FOUND_LINE.getMessage());
            }
            LineRepository.deleteLineByName(LineName);
            outputView.printRemoveLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return LineOption.DELETE;
    }
}
