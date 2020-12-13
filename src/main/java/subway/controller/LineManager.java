package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class LineManager implements Message {

    protected static void register() {
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

    protected static void delete() {
        if (LineRepository.deleteLineByName(InputView.getLineNameToDelete())) {
            OutputView.printInfo(INFO_LINE_DELETED);
            return;
        }
        OutputView.printError(ERROR_NOT_REGISTERED_LINE);
    }
}
