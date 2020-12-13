package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManager extends Manager implements Message {

    public static void request(String selection) {
        if (selection.equals(REGISTER)) {
            registerLine();
            return;
        }
        if (selection.equals(DELETE)) {
            deleteLine();
            return;
        }
        if (selection.equals(PRINT)) {
            OutputView.printLines();
            return;
        }
        OutputView.printError(ERROR_INVALID_SELECTION);
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
