package subway.controller;

import static subway.util.TextConstant.*;

import subway.domain.StationFactory;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class StationMenuHandler {
    public static void addStation() {
        OutputView.showAddMessage(STATION);
        StationRepository.addStation(StationFactory.makeStation(InputView.nextLine().trim()));
        OutputView.showCompleteMessage(SUBWAY_STATION, ADD);
    }

    public static void deleteStation() {
        OutputView.showDeleteMessage(STATION);
        StationRepository.deleteStation(InputView.nextLine().trim());
        OutputView.showCompleteMessage(SUBWAY_STATION, DELETE);
    }

    public static void showStation() {
        List<String> stationNames = StationRepository.getStationNames();
        if (stationNames.isEmpty()) {
            OutputView.showEmptyListMessage(SUBWAY_STATION);
            return;
        }
        OutputView.showList(stationNames);
    }

    public static void back() {
    }
}
