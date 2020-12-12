package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    public static void addLine() {
        try {
            tryToAddLine();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }
    
    private static void tryToAddLine() {
        OutputView.requestLineNameToAdd();
        String name = InputView.getInput();
        OutputView.requestUpstreamTerminus();
        String upstreamTerminus = InputView.getInput();
        OutputView.requestDownstreamTerminus();
        String downstreamTerminus = InputView.getInput();

        LineRepository.addLine(Line.createLineWithTerminus(name, upstreamTerminus, downstreamTerminus));
        OutputView.informLineAdded();
    }
    
    public static void deleteLine() {
        try {
            tryToDeleteLine();
            backToMainMenu();
        } catch (Exception exception) {
            catchError(exception);
        }
    }

    private static void tryToDeleteLine() {
        OutputView.requestLineNameToDelete();
        LineRepository.deleteLineByName(InputView.getInput());
    }

    public static void backToMainMenu() {
        SubwayMapController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        SubwayMapController.callLineMenu();
    }
}
