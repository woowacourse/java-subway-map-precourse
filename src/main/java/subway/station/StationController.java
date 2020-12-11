package subway.station;

import subway.station.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private StationController() {
    }

    public static void register() {
        String name = InputView.getStationNameForRegistration();
        StationService.register(name);
    }

    public static void remove() {
        String name = InputView.getStationNameForRemoval();
        StationService.remove(name);
    }

    public static void inquire() {
        StationRepository.stations()
                .forEach(OutputView::printStation);
    }
}
