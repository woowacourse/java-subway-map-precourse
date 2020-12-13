package subway.function.station;

import java.util.Scanner;
import java.util.regex.Pattern;
import subway.common.ResolveResultType;
import subway.common.print.error.CommonErrorPrinter;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.function.station.printer.PrintStationManagementScreen;
import subway.function.station.printer.StationManagementPrinter;
import subway.function.station.printer.error.StationManagementErrorPrinter;
import subway.main.UserSelections;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationManagement {
    public static void start(Scanner scanner) {
        String selectionInputPattern = "^[123B]$";
        while (true) {
            String userInput = printAndGetUserSelectionInput(scanner);
            if (!isValidSelectionInput(selectionInputPattern, userInput)) {
                continue;
            }
            StationManagementSelectionType type = getStationManagementSelectionType(userInput);
            ResolveResultType result = resolveStationManagement(type, scanner);
            if (result == ResolveResultType.ERROR) {
                continue;
            }
            break;
        }
    }

    private static boolean isValidSelectionInput(String selectionInputPattern, String userInput) {
        if (!Pattern.matches(selectionInputPattern, userInput)) {
            CommonErrorPrinter.printSelectionInputErrorMessage();
            return false;
        }
        return true;
    }

    private static String printAndGetUserSelectionInput(Scanner scanner) {
        printScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        return scanner.nextLine();
    }

    private static StationManagementSelectionType getStationManagementSelectionType(
        String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return StationManagementSelectionType.STATION_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return StationManagementSelectionType.STATION_DELETE;
        }
        if (userInput.equals(UserSelections.THIRD)) {
            return StationManagementSelectionType.STATION_PRINT_ALL;
        }
        return StationManagementSelectionType.GO_BACK;
    }

    private static ResolveResultType resolveStationManagement(StationManagementSelectionType type,
        Scanner scanner) {
        if (type == StationManagementSelectionType.STATION_REGISTRATION) {
            return registerNewStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_DELETE) {
            return deleteStation(scanner);
        }
        if (type == StationManagementSelectionType.STATION_PRINT_ALL) {
            return printAllStations();
        }
        return ResolveResultType.ERROR;
    }

    private static ResolveResultType printAllStations() {
        StationRepository.printAll();
        return ResolveResultType.SUCCESS;
    }

    private static ResolveResultType deleteStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        if (!isValidStationNameToDelete(stationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    private static boolean isValidStationNameToDelete(String stationName) {
        if (!isExistsStationName(stationName)) {
            StationManagementErrorPrinter.printNotExistsStationNameErrorMessage();
            return false;
        }
        if (isRegisteredInLineStationName(stationName)) {
            StationManagementErrorPrinter.printRegisteredInLineStationNameErrorMessage();
            return false;
        }
        return true;
    }

    private static boolean isRegisteredInLineStationName(String stationName) {
        return LineStationMappingRepository.isStationNameRegisteredInLine(stationName);
    }

    private static ResolveResultType registerNewStation(Scanner scanner) {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        if (!isValidStationNameToRegister(newStationName)) {
            return ResolveResultType.ERROR;
        }
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
        return ResolveResultType.SUCCESS;
    }

    private static boolean isValidStationNameToRegister(String newStationName) {
        if (CommonValidator.isLengthLessThanMinLength(newStationName)) {
            StationManagementErrorPrinter.printNewStationNameLengthErrorMessage();
            return false;
        }
        if (isExistsStationName(newStationName)) {
            StationManagementErrorPrinter.printAlreadyExistsStationNameErrorMessage();
            return false;
        }
        return true;
    }

    private static boolean isExistsStationName(String stationName) {
        return StationRepository.findByName(stationName) != null;
    }

    private static void printScreen() {
        PrintStationManagementScreen.printStationManagementScreen();
    }
}
