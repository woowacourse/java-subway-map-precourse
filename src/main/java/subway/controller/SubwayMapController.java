package subway.controller;

import subway.domain.command.Command;
import subway.domain.screen.MainScreen;
import subway.domain.screen.ScreenType;
import subway.domain.station.Station;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

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
        runMainScreen(currentScreenType);
    }

    private void runMainScreen(ScreenType currentScreenType) {
        if (!currentScreenType.isMainScreen()) {
            return;
        }
        OutputView.showMainScreen();
        Command command = inputView.inputMainCommand();
        currentScreen = MainScreen.getInstance().getNextScreen(command);
    }

    public void registerStation(Station station) {
        stationService.addStation(station);
    }

    public void unregisterStation(String stationName) {
        // TODO : 노선에 등록되어 있는지 체크
        // lineService.isExistent(stationName)
        stationService.deleteStation(stationName);
    }
}
