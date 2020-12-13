package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManager implements Message {
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";

    public static void request(String selection) {
        if (selection.equals(REGISTER)) {
            registerLine();
        }
        if (selection.equals(DELETE)) {
            deleteLine();
        }
        if (selection.equals(PRINT)) {
            OutputView.printLines();
        }
    }

    private static void registerLine() {
        try {
            String name = InputView.getLineName();
            Line newLine = new Line(name);

            OutputView.printAnnouncement(ANN_REGISTER_FIRST_STATION);
            Station firstStation = StationManager.getStation();
            newLine.addFirst(firstStation);

            OutputView.printAnnouncement(ANN_REGISTER_LAST_STATION);
            Station lastStation = StationManager.getStation();
            newLine.addLast(lastStation);

            LineRepository.addLine(newLine);
            OutputView.printInfo(INFO_LINE_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void deleteLine() {
        OutputView.printAnnouncement(ANN_DELETE_LINE);
        String name = InputView.getInput();
        if (LineRepository.deleteLineByName(name)) {
            OutputView.printInfo(INFO_LINE_DELETED);
            return;
        }
        OutputView.printError(ERROR_NOT_REGISTERED_LINE);
    }
}
