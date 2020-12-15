package subway.controller;

import subway.domain.SectionRepository;
import subway.view.OutputView;
import subway.view.resource.Screen;

public class MapController {
    private MapController() {

    }

    public static void run() {
        printSubwayMap();
        goBackToMain();
    }

    private static void printSubwayMap() {
        OutputView.printTitle(Screen.MAP.getName());
        OutputView.printSubwayMap(SectionRepository.sections());
    }

    private static void goBackToMain() {
        MainController.run();
    }
}
