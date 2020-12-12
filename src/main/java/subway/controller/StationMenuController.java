package subway.controller;

import subway.exception.GoBackToPrevControllerException;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationMenuController {

    public static final String TITLE = "역 관리 화면";

    public static final String REGISTER_STATION = "1";
    public static final String UNREGISTER_STATION = "2";
    public static final String LIST_STATIONS = "3";
    public static final String GO_BACK = "B";

    private StationMenuController() {
    }

    public static void main() {
        printMenu();
        while (true) {
            try {
                route(InputView.getInput());
            } catch (GoBackToPrevControllerException e) {
                return;
            } catch (Exception e) {
                OutputView.printError(e);
                return;
            }
        }
    }

    private static void route(String input) {
        if (REGISTER_STATION.equals(input)) {
            registerStation();
            return;
        }

        if (UNREGISTER_STATION.equals(input)) {
            unregisterStation();
            return;
        }

        if (LIST_STATIONS.equals(input)) {
            listStations();
            return;
        }

        if (GO_BACK.equals(input)) {
            throw new GoBackToPrevControllerException();
        }
    }

    private static void listStations() {
        StationService.listAllStations();
    }

    private static void unregisterStation() {
        while (true) {
            try {
                StationService.removeStationByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void registerStation() {
        while (true) {
            try {
                StationService.resisterStationByName(InputView.getInput());
                return;
            } catch (Exception e) {
                OutputView.printError(e);
            }
        }
    }

    private static void printMenu() {
        OutputView.printInfo(TITLE);
    }
}
