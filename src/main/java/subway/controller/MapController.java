package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.text.Screen;

public class MapController {
    public void run(InputView inputView) {
        printSubwayMap();
        goBackToMain(inputView);
    }

    private void printSubwayMap() {
        OutputView.printTitle(Screen.MAP.getName());
        OutputView.printSubwayMap(SectionRepository.sections());
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }
}
