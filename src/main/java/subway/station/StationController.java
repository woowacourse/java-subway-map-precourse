package subway.station;

import subway.station.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.StationMessage;

public class StationController {
    private StationController() {
    }

    public static void execute() {
        OutputView.printGuide(StationMessage.SELECT_FUNCTION);
        String command = InputView.getFunction();
        Runnable function = StationFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String name = InputView.getStationNameForRegistration();
        StationService.register(name);
        OutputView.printlnResult(StationMessage.COMPLETE_REGISTRATION);
    }

    public static void remove() {
        String name = InputView.getStationNameForRemoval();
        StationService.remove(name);
        OutputView.printlnResult(StationMessage.COMPLETE_REMOVAL);
    }

    public static void inquire() {
        OutputView.printStations(StationRepository.findAll());
    }
}
