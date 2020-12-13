package subway.controller;

import subway.domain.SectionRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class MapController {
    private static String CONTROLLER_INDEX = "4";
    private static String FUNCTION_TITLE = "지하철 노선도";

    public void run(InputView inputView) {
        printSubwayMap();
        goBackToMain(inputView);
    }

    private void printSubwayMap() {
        OutputView.printFunctionTitle(FUNCTION_TITLE);
        OutputView.printSubwayMap(SectionRepository.sections());
    }

    private void goBackToMain(InputView inputView) {
        MainController.run(inputView);
    }

    public static String getControllerIndex() {
        return CONTROLLER_INDEX;
    }
}
