package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class MapController extends Controller {

    public MapController(InputView inputView) {
        super(inputView);
    }

    @Override
    public void run() {
        try {
            OutputView.printMap();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }
}
