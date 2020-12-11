package subway.station;

import subway.station.domain.StationRepository;
import subway.station.exception.NotSupportedFunctionException;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private StationController() {
    }

    public static void execute() {
        String command = InputView.getStationFunction();
        Runnable function = StationFunctionMapper.matchFunction(command)
                .orElseThrow(NotSupportedFunctionException::new);
        function.run();
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
