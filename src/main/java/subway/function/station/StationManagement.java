package subway.function.station;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.function.station.printer.PrintStationManagementScreen;
import subway.function.station.printer.StationManagementPrinter;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationManagement {

    public static void start(Scanner scanner) {
        while (true) {
            StationManagementSelectionType type = null;
            type = printAndGetUserSelectionInput(scanner);
            if (type == StationManagementSelectionType.GO_BACK) {
                return;
            }
            StationManagementTypeResolver.resolveStationManagement(type, scanner);
        }
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }

    private static StationManagementSelectionType printAndGetUserSelectionInput(Scanner scanner) {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        try {
            CommonValidator
                .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                    userInput);
        } catch (IllegalArgumentException e) {
            return StationManagementSelectionType.ERROR;
        }
        return StationManagementTypeResolver.getStationManagementSelectionType(userInput);
    }

    public static void registerNewStation(Scanner scanner) throws IllegalArgumentException {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationManagementValidator.validateStationNameToRegister(newStationName);
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
    }

    public static void deleteStation(Scanner scanner) throws IllegalArgumentException {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        StationManagementValidator.validateStationNameToDelete(stationName);
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
    }

    public static void printAllStations() {
        StationRepository.printAll();
    }
}
