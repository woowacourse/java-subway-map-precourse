package subway.controller;

import subway.domain.StationFactory;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuHandler {

    public static final String STATION = "역";

    public static void addStation() {
        OutputView.showAddMenu(STATION);
        StationRepository.addStation(StationFactory.makeStation(InputView.nextLine().trim()));
    }

    public static void deleteStation() {
        OutputView.showDeleteMenu(STATION);
        StationRepository.deleteStation(InputView.nextLine().trim());
    }

    public static void showStation() {
        OutputView.showList(StationRepository.stations().stationNames());
    }

    public static void back() {
    }
}
