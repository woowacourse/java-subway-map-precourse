package subway.controller.map;

import java.util.List;
import subway.controller.MainOption;
import subway.controller.SubController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MapController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;

    public MapController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public MainOption process() {
        List<Line> lines = LineRepository.lines();
        outputView.printAllLineWithStation(lines);
        return MainOption.MAP;
    }
}
