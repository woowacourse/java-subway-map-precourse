package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.ParsingUtil;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.SectionOutputView;

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
        SectionOutputView.requestLineForAddSection();
        String lineName = InputView.getInput();
        SectionOutputView.requestStationForAddSection();
        String stationName = InputView.getInput();
        SectionOutputView.requestSectionOrder();
        int index = ParsingUtil.stringToPositiveInteger(InputView.getInput()) - 1;

        Line line = LineRepository.getLine(lineName);
        line.addSection(index, stationName);
        SectionOutputView.informSectionAdded();
    }

    public static void deleteSection() {
        try {
            tryToDeleteSection();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToDeleteSection() {
        SectionOutputView.requestLineForDeleteSection();
        String lineName = InputView.getInput();
        SectionOutputView.requestStationForDeleteSection();
        String stationName = InputView.getInput();

        Line line = LineRepository.getLine(lineName);
        line.deleteSection(stationName);
        SectionOutputView.informSectionDeleted();
    }

    public static void backToMainMenu() {
        SubwayMapController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        SubwayMapController.callSectionMenu();
    }
}
