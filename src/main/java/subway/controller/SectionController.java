package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.ParsingUtil;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {
    public static void addSection() {
        try {
            tryToAddSection();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToAddSection() {
        OutputView.requestLineForAddSection();
        String lineName = InputView.getInput();
        OutputView.requestStationForAddSection();
        String stationName = InputView.getInput();
        OutputView.requestSectionOrder();
        int index = ParsingUtil.stringToPositiveInteger(InputView.getInput()) - 1;

        Line line = LineRepository.getLine(lineName);
        line.addSection(index, stationName);
        OutputView.informLineAdded();
    } 

    public static void backToMainMenu() {
        SubwayMapController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        SubwayMapController.callLineMenu();
    }
}
