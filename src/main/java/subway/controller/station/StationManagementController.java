package subway.controller.station;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.InvalidFunctionException;
import subway.exception.SubwayApplicationException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.service.StationDeleteService;
import subway.service.StationGenerateService;
import subway.service.StationListService;
import subway.service.StationRegisterService;
import subway.view.inputView.InputView;
import subway.view.output.MainMenuView;
import subway.view.output.OutputView;
import subway.view.output.StationManagementView;

import java.util.List;

public class StationManagementController implements Runnable {

    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public StationManagementController(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    @Override
    public void run() {
        try {
            MainMenuView.printMenu(StationManagementMenu.toMenuString());
            Runnable function = selectFunction();

            if (function == null) {
                return;
            }

            function.run();
        } catch (SubwayApplicationException e) {
            run();
        }
    }

    private Runnable selectFunction() {
        MainMenuView.chooseFunction();
        String input = InputView.scan();

        Runnable function;
        try {
            function = StationManagementMenu.find(input);
        } catch (InvalidFunctionException e) {
            OutputView.print(e.getMessage());
            return selectFunction();
        }

        return function;
    }

    public void registerStation() {
        StationManagementView.printRegisterMessage();

        String name = InputView.scan();

        Station station = new StationGenerateService().generate(name);
        new StationRegisterService(stationRepository).register(station);

        StationManagementView.printRegisterFinishMessage();
    }

    public void deleteStation() {
        StationManagementView.printDeleteMessage();

        String name = InputView.scan();

        StationName stationName = StationName.of(name);
        new StationDeleteService(stationRepository, lineRepository).delete(stationName);

        StationManagementView.printDeleteFinishMessage();
    }

    public void viewStations() {
        List<Station> stations = new StationListService(stationRepository).get();
        StationManagementView.printStationList(stations);
    }
}
