package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.LineOutputView;
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
        LineOutputView.requestLineNameToAdd();
        String name = InputView.getInput();
        LineOutputView.requestUpstreamTerminus();
        String upstreamTerminus = InputView.getInput();
        LineOutputView.requestDownstreamTerminus();
        String downstreamTerminus = InputView.getInput();

        LineRepository.addLine(Line.createWithInitialStations(
                name, upstreamTerminus, downstreamTerminus));
        LineOutputView.informLineAdded();
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
        LineOutputView.requestLineNameToDelete();
        LineRepository.deleteLineByName(InputView.getInput());
        LineOutputView.informLineDeleted();
    }

    public static void showLines() {
        LineOutputView.printLines();
        backToMainMenu();
    }

    public static void backToMainMenu() {
        SubwayMapController.callMainMenu();
    }

    private static void catchError(Exception exception) {
        OutputView.printError(exception);
        SubwayMapController.callLineMenu();
    }
}
