package subway.controller;

import subway.domain.command.LineCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionCommand;
import subway.domain.command.StationCommand;
import subway.domain.line.Line;
import subway.domain.screen.LineManagementScreen;
import subway.domain.screen.MainScreen;
import subway.domain.screen.ScreenType;
import subway.domain.screen.SectionManagementScreen;
import subway.domain.screen.StationManagementScreen;
import subway.domain.station.Station;
import subway.dto.LineDto;
import subway.dto.SectionDeletionDto;
import subway.dto.SectionRegistrationDto;
import subway.dto.StationDto;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayMapController {
    private final InputView inputView;
    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;
    private ScreenType currentScreen = ScreenType.MAIN;

    public SubwayMapController(Scanner scanner) {
        inputView = new InputView(scanner);
        stationService = new StationService();
        lineService = new LineService();
        sectionService = new SectionService();
    }

    public void run() {
        while (isRunning()) {
            runScreen(currentScreen);
        }
    }

    public boolean isRunning() {
        return !currentScreen.isExitScreen();
    }

    private void runScreen(ScreenType currentScreenType) {
        runMainScreenIfAble(currentScreenType);
        runStationManagementScreenIfAble(currentScreenType);
        runLineManagementScreenIfAble(currentScreenType);
        runSectionManagementScreenIfAble(currentScreenType);
        runSubwayMapPrintScreenIfAble(currentScreenType);
    }

    private void runMainScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isMainScreen()) {
            return;
        }
        OutputView.showMainScreen();
        try {
            MainCommand mainCommand = inputView.inputMainCommand();
            currentScreen = MainScreen.getInstance().getNextScreen(mainCommand);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
    }

    private void runStationManagementScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isStationManagementScreen()) {
            return;
        }
        OutputView.showStationManagementScreen();
        try {
            StationCommand stationCommand = inputView.inputStationCommand();
            manageStation(stationCommand);
            currentScreen = StationManagementScreen.getInstance().getNextScreen(stationCommand);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
    }

    private void manageStation(StationCommand stationCommand) {
        manageIfStationRegistrationCommand(stationCommand);
        manageIfStationDeletionCommand(stationCommand);
        manageIfPrintStationsCommand(stationCommand);
    }

    private void manageIfStationRegistrationCommand(StationCommand stationCommand) {
        if (!stationCommand.isStationRegistration()) {
            return;
        }
        StationDto stationDto = inputView.inputRegistrationStation();
        Station station = stationDto.toStation();
        registerStation(station);
        OutputView.showStationRegistrationSuccess();
    }

    public void registerStation(Station station) {
        stationService.addStation(station);
    }

    private void manageIfStationDeletionCommand(StationCommand stationCommand) {
        if (!stationCommand.isStationDeletion()) {
            return;
        }
        String stationName = inputView.inputDeletionStation();
        unregisterStation(stationName);
        OutputView.showStationDeletionSuccess();
    }

    public void unregisterStation(String stationName) {
        stationService.deleteStation(stationName);
    }

    private void manageIfPrintStationsCommand(StationCommand stationCommand) {
        if (!stationCommand.isPrintStations()) {
            return;
        }
        List<String> stationNames = stationService.getStationNames();
        OutputView.showStationList(stationNames);
    }

    private void runLineManagementScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isLineManagementScreen()) {
            return;
        }
        OutputView.showLineManagementScreen();
        try {
            LineCommand lineCommand = inputView.inputLineCommand();
            manageLine(lineCommand);
            currentScreen = LineManagementScreen.getInstance().getNextScreen(lineCommand);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
    }

    private void manageLine(LineCommand lineCommand) {
        manageIfLineRegistrationCommand(lineCommand);
        manageIfLineDeletionCommand(lineCommand);
        manageIfPrintLinesCommand(lineCommand);
    }

    private void manageIfLineRegistrationCommand(LineCommand lineCommand) {
        if (!lineCommand.isLineRegistration()) {
            return;
        }
        LineDto lineDto = inputView.inputRegistrationLine();
        lineService.addLine(lineDto);
        OutputView.showLineRegistrationSuccess();
    }

    private void manageIfLineDeletionCommand(LineCommand lineCommand) {
        if (!lineCommand.isLineDeletion()) {
            return;
        }
        String lineName = inputView.inputDeletionLine();
        lineService.deleteLine(lineName);
        OutputView.showLineDeletionSuccess();
    }

    private void manageIfPrintLinesCommand(LineCommand lineCommand) {
        if (!lineCommand.isPrintLines()) {
            return;
        }
        List<String> lineNames = lineService.getLineNames();
        OutputView.showLineList(lineNames);
    }

    private void runSectionManagementScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isSectionManagementScreen()) {
            return;
        }
        OutputView.showSectionManagementScreen();
        try {
            SectionCommand sectionCommand = inputView.inputSectionCommand();
            manageSection(sectionCommand);
            currentScreen = SectionManagementScreen.getInstance().getNextScreen(sectionCommand);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
        }
    }

    private void manageSection(SectionCommand sectionCommand) {
        manageIfSectionRegistrationCommand(sectionCommand);
        manageIfSectionDeletionCommand(sectionCommand);
    }

    private void manageIfSectionRegistrationCommand(SectionCommand sectionCommand) {
        if (!sectionCommand.isSectionRegistration()) {
            return;
        }
        SectionRegistrationDto sectionRegistrationDto = inputView.inputRegistrationSection();
        sectionService.addSection(sectionRegistrationDto);
        OutputView.showSectionRegistrationSuccess();
    }

    private void manageIfSectionDeletionCommand(SectionCommand sectionCommand) {
        if (!sectionCommand.isSectionDeletion()) {
            return;
        }
        SectionDeletionDto sectionDeletionDto = inputView.inputDeletionSection();
        sectionService.deleteSection(sectionDeletionDto);;
        OutputView.showSectionDeletionSuccess();
    }

    private void runSubwayMapPrintScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isSubwayMapPrintScreen()) {
            return;
        }
        List<Line> lines = lineService.getLines();
        OutputView.showSubwayMap(lines);
        currentScreen = ScreenType.MAIN;
    }
}
