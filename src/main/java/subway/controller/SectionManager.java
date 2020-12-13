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
            OutputView.printAnnouncement(ANN_SELECT_LINE);
            Line line = LineRepository.getLine(InputView.getInput());
            OutputView.printAnnouncement(ANN_SELECT_STATION);
            Station station = StationManager.getStation();
            OutputView.printAnnouncement(ANN_INPUT_ORDER);
            int index = Integer.parseInt(InputView.getInput());
            line.insertStation(index, station);
            OutputView.printInfo(INFO_SECTION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void removeStationFromLine() {
        try {
            OutputView.printAnnouncement(ANN_DELETE_SECTION_LINE);
            Line line = LineRepository.getLine(InputView.getInput());
            OutputView.printAnnouncement(ANN_DELETE_SECTION_STATION);
            // TODO : getStation을 StationRepository의 클래스 메서드로 리팩토링
            Station station = StationManager.getStation();
            line.removeStation(station);
            OutputView.printInfo(INFO_SECTION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
