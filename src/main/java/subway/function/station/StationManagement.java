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
            try {
                type = printAndGetUserSelectionInput(scanner);
            } catch (Exception ignored) {
            }
            if (type == StationManagementSelectionType.GO_BACK) {
                return;
            }
            try {
                StationManagementTypeResolver.resolveStationManagement(type, scanner);
            } catch (Exception ignored) {
            }
        }
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }

    private static StationManagementSelectionType printAndGetUserSelectionInput(Scanner scanner)
        throws Exception {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        CommonValidator
            .validateSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B, userInput);
        return StationManagementTypeResolver.getStationManagementSelectionType(userInput);
    }

    public static void registerNewStation(Scanner scanner) throws Exception {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationManagementValidator.validateStationNameToRegister(newStationName);
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
    }

    public static void deleteStation(Scanner scanner) throws Exception {
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
