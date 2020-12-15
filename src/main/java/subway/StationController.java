package subway;

import java.util.Scanner;
import subway.constant.BoundaryCheckDigit;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.constant.UserChoiceOptionToName;

public class StationController {

    private StationController() {

    }

    public static void stationControlMenu(Scanner scanner) {
        String choiceMenu;
        boolean workStatus = false;

        while (isWorkSuccess(workStatus)) {
            OutputView.stationMenuPrint();
            choiceMenu = InputView.scanStationMenu(scanner);

            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_ADD.getUserChoiceOptionToName())) {
                workStatus = stationAdd(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_DELETE.getUserChoiceOptionToName())) {
                workStatus = stationDelete(scanner);
            }
            if (choiceMenu.
                equals(UserChoiceOptionToName.STATION_CHECK.getUserChoiceOptionToName())) {
                workStatus = stationCheck();
            }
            if (choiceMenu.equals(UserChoiceOptionToName.BACK.getUserChoiceOptionToName())) {
                break;
            }
        }
    }

    private static boolean isWorkSuccess(boolean workStatus) {
        return !workStatus;
    }

    private static boolean stationAdd(Scanner scanner) {
        String stationName;
        try {
            stationName = InputView.scanStationAddName(scanner);
        } catch (IllegalArgumentException error) {
            return false;
        }

        Station newStation = new Station(stationName);
        StationRepository.addStation(newStation);
        return true;
    }

    private static boolean stationDelete(Scanner scanner) {
        String stationName;

        stationName = InputView.scanStationDeleteName(scanner);

        if (notFoundStationName(stationName)) {
            OutputView.stationNameDeleteErrorPrint();
            return false;
        }
        if (isAlreadyRegisteredStation(stationName)) {
            OutputView.lineRegisteredStationErrorPrint();
            return false;
        }

        OutputView.stationDeleteSuccessPrint();
        return true;
    }

    private static boolean isAlreadyRegisteredStation(String stationName) {
        return StationRepository.registeredStationsInLine().contains(stationName);
    }

    private static boolean notFoundStationName(String stationName) {
        return !StationRepository.contains(stationName);
    }

    private static boolean stationCheck() {
        String[] stationList;
        stationList = StationRepository.getAllStationNames().toArray(String[]::new);

        if (isEmptyStationRepository(stationList)) {
            OutputView.zeroStationListErrorPrint();
            return false;
        }

        OutputView.stationListPrint(stationList);
        return true;
    }

    private static boolean isEmptyStationRepository(String[] stationList) {
        return stationList.length < BoundaryCheckDigit.STATION_LIST_LIMIT_MINIMUM
            .getBoundaryCheckDigit();
    }


}
