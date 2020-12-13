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
            Line newLine = new Line(InputView.getLineName());

            Station firstStation = StationManager.getStation(InputView.getFirstStationName());
            newLine.addFirst(firstStation);

            Station lastStation = StationManager.getStation(InputView.getLastStationName());
            newLine.addLast(lastStation);

            LineRepository.addLine(newLine);
            OutputView.printInfo(INFO_LINE_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void deleteLine() {
        if (LineRepository.deleteLineByName(InputView.getLineNameToDelete())) {
            OutputView.printInfo(INFO_LINE_DELETED);
            return;
        }
        OutputView.printError(ERROR_NOT_REGISTERED_LINE);
    }
}
