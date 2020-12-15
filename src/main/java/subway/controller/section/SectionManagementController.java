package subway.controller.section;

import subway.domain.line.LineName;
import subway.domain.station.StationName;
import subway.exception.InvalidFunctionException;
import subway.exception.SubwayApplicationException;
import subway.repository.line.LineRepository;
import subway.repository.station.StationRepository;
import subway.service.SectionDeleteService;
import subway.service.SectionRegisterService;
import subway.service.StationGenerateService;
import subway.service.StationRegisterService;
import subway.view.inputView.InputView;
import subway.view.output.MainMenuView;
import subway.view.output.OutputView;
import subway.view.output.SectionManagementView;
import subway.view.output.StationManagementView;

public class SectionManagementController implements Runnable {

    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public SectionManagementController(StationRepository stationRepository, LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
    }

    @Override
    public void run() {
        try {
            MainMenuView.printMenu(SectionManagementMenu.toMenuString());
            Runnable function = selectFunction();
            if (function == null) {
                return;
            }
            function.run();
        } catch (SubwayApplicationException e) {
            OutputView.print(e.getMessage());
            run();
        }

    }

    private Runnable selectFunction() {
        MainMenuView.chooseFunction();
        String input = InputView.scan();

        Runnable function;
        try {
            function = SectionManagementMenu.find(input);
        } catch (InvalidFunctionException e) {
            OutputView.print(e.getMessage());
            return selectFunction();
        }

        return function;
    }

    public void registerSection() {
        SectionManagementView.printLineInputMessage();
        String line = InputView.scan();

        SectionManagementView.printStationNameInputMessage();
        String station = InputView.scan();

        SectionManagementView.printPositionInputMessage();
        String position = InputView.scan();

        new SectionRegisterService(stationRepository, lineRepository).add(line, station, position);

        SectionManagementView.printRegisterFinishMessage();
    }

    public void deleteSection() {
        SectionManagementView.printDeleteLineInputMessage();
        String line = InputView.scan();
        LineName lineName = LineName.of(line);

        SectionManagementView.printDeleteStationInputMessage();
        String station = InputView.scan();
        StationName stationName = StationName.of(station);

        new SectionDeleteService(lineRepository).delete(lineName, stationName);

        SectionManagementView.printDeleteFinishMessage();
    }
}
