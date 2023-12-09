package subway.controller.line;

import static subway.util.Retry.retry;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.SubController;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<LineOption, SubController> subLineControllers = new EnumMap<>(LineOption.class);

    public LineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subLineControllers.put(LineOption.ADD, new LineAddController(inputView, outputView));
        subLineControllers.put(LineOption.DELETE, new LineRemoveController(inputView, outputView));
        subLineControllers.put(LineOption.LIST, new LineFindController(outputView));
    }

    @Override
    public void process() {
        while (true) {
            LineOption lineOption = retry(inputView::readLineOption);
            if (lineOption.isBack()) {
                break;
            }
            subLineControllers.get(lineOption).process();
        }
    }
}
