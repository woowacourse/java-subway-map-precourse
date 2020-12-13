package subway.controller;

import subway.domain.command.MainCommand;
import subway.domain.command.StationCommand;
import subway.domain.screen.MainScreen;
import subway.domain.screen.ScreenType;
import subway.domain.screen.StationManagementScreen;
import subway.domain.station.Station;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayMapController {
    private final InputView inputView;
    private final StationService stationService;
    private ScreenType currentScreen = ScreenType.MAIN;

    public SubwayMapController(Scanner scanner) {
        inputView = new InputView(scanner);
        stationService = new StationService();
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
    }

    private void runMainScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isMainScreen()) {
            return;
        }
        OutputView.showMainScreen();
        MainCommand mainCommand = inputView.inputMainCommand();
        currentScreen = MainScreen.getInstance().getNextScreen(mainCommand);
    }

    private void runStationManagementScreenIfAble(ScreenType currentScreenType) {
        if (!currentScreenType.isStationManagementScreen()) {
            return;
        }
        OutputView.showStationManagementScreen();
        StationCommand stationCommand = inputView.inputStationCommand();
        manageStation(stationCommand);
        currentScreen = StationManagementScreen.getInstance().getNextScreen(stationCommand);
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
        Station station = inputView.inputRegistrationStation();
        registerStation(station);
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
    }

    public void unregisterStation(String stationName) {
        stationService.deleteStation(stationName);
    }

    private void manageIfPrintStationsCommand(StationCommand stationCommand) {
        if (!stationCommand.isPrintStations()) {
            return;
        }
        List<String> stationNames = stationService.getStationNamesWithoutRedundancy();
        OutputView.showStationList(stationNames);
    }
}
