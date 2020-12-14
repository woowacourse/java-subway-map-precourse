package subway.controller;

import subway.domain.SectionRepository;
import subway.view.OutputView;
import subway.view.resource.Screen;

public class MapController {
    public void run() {
        printSubwayMap();
        goBackToMain();
    }

    private void printSubwayMap() {
        OutputView.printTitle(Screen.MAP.getName());
        OutputView.printSubwayMap(SectionRepository.sections());
    }

    private void goBackToMain() {
        MainController.run();
    }
}
