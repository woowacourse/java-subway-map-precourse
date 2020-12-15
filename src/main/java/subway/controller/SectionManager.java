package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionManager implements Message {

    protected static void insertStationInLine() {
        Line line = LineRepository.getLine(InputView.getLineNameInSection());
        Station station = StationManager.getStation(InputView.getStationNameInSection());
        int index = Integer.parseInt(InputView.getOrderInSection());
        line.insertStation(index, station);
        OutputView.printInfo(INFO_SECTION_REGISTERED);
    }

    protected static void removeStationFromLine() {
        Line line = LineRepository.getLine(InputView.getLineNameToDeleteInSection());
        Station station = StationManager.getStation(InputView.getStationNameToDeleteInSection());
        line.removeStation(station);
        OutputView.printInfo(INFO_SECTION_DELETED);
    }
}
