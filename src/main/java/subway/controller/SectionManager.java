package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManager implements Message {

    private static final String INSERT = "1";
    private static final String REMOVE = "2";

    public static void request(String selection) {
        if (selection.equals(INSERT)) {
            insertStationInLine();
        }
        if (selection.equals(REMOVE)) {
            removeStationFromLine();
        }
    }

    private static void insertStationInLine() {
        try {
            Line line = LineRepository.getLine(InputView.getLineNameInSection());
            Station station = StationManager.getStation(InputView.getStationNameInSection());
            int index = Integer.parseInt(InputView.getOrderInSection());
            line.insertStation(index, station);
            OutputView.printInfo(INFO_SECTION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void removeStationFromLine() {
        try {
            Line line = LineRepository.getLine(InputView.getLineNameToDeleteInSection());
            Station station = StationManager.getStation(InputView.getStationNameToDeleteInSection());
            line.removeStation(station);
            OutputView.printInfo(INFO_SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
