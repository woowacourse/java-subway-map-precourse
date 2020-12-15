package subway.Controller.domain;

import subway.Controller.MainController;
import subway.domain.LineRepository;
import subway.view.OutputView;

public class MapController {

    public static void run() {
        traverse();
    }

    private static void traverse() {
        OutputView.printMap(LineRepository.lines());
        MainController.run();
    }
}
