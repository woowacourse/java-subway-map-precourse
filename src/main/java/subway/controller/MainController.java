package subway.controller;

import static subway.util.Retry.retry;

import java.util.EnumMap;
import java.util.Map;
import subway.domain.MainOption;
import subway.view.InputView;
import subway.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<MainOption, SubController> subControllers = new EnumMap<>(MainOption.class);

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subControllers.put(MainOption.STATION, new StationController(inputView, outputView));
        subControllers.put(MainOption.LINE, new LineController(inputView, outputView));
        subControllers.put(MainOption.SECTION, new SectionController(inputView, outputView));
        subControllers.put(MainOption.MAP, new MapController(inputView, outputView));
        subControllers.put(MainOption.QUIT, new QuitController(inputView, outputView));
    }

    public void run() {
        while (true) {
            MainOption mainOption = retry(inputView::readMainOption);
            SubController subController = subControllers.get(mainOption);
            if (subController.process().isQuit()) {
                break;
            }
        }
    }
}
