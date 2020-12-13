package subway.function.line;

import java.util.Scanner;
import subway.common.print.info.CommonInfoPrinter;
import subway.common.validator.CommonValidator;
import subway.domain.line.LineRepository;
import subway.domain.LineStationMappingRepository;
import subway.domain.station.Station;
import subway.function.line.printer.LineManagementPrinter;
import subway.function.line.printer.PrintLineManagementScreen;

public class LineManagement {
    public static void start(Scanner scanner) {
        while (true) {
            LineManagementSelectionType type = null;
            type = printAndGetUserSelection(scanner);
            if (type == LineManagementSelectionType.GO_BACK) {
                return;
            }
            LineManagementTypeResolver.resolveUserSelection(type, scanner);
        }
    }

    private static LineManagementSelectionType printAndGetUserSelection(Scanner scanner) {
        PrintLineManagementScreen.printLineManagementScreen();
        CommonInfoPrinter.printUserFunctionSelectionMessage();
        String userInput = scanner.nextLine();
        try {
            CommonValidator
                .validateIsCorrectSelectionInput(CommonValidator.SELECTION_INPUT_PATTERN_123B,
                    userInput);
        } catch (IllegalArgumentException e) {
            return LineManagementSelectionType.ERROR;
        }
        return LineManagementTypeResolver.getLineManagementSelectionType(userInput);
    }

    public static void registerNewLine(Scanner scanner) throws IllegalArgumentException {
        String newLineName = getNewLineNameInput(scanner);
        Station upEndStation = getEndStationNameInput(scanner);
        Station downEndStation = getDownEndStationNameInput(scanner);
        LineManagementValidator.validateIsNotEqual(upEndStation, downEndStation);
        LineStationMappingRepository
            .createNewLineByStations(newLineName, upEndStation, downEndStation);
        LineManagementPrinter.printNewLineRegistrationSuccessMessage();
    }

    private static Station getDownEndStationNameInput(Scanner scanner) throws IllegalArgumentException {
        LineManagementPrinter.printLineDownEndStationNameInputMessage();
        String downEndStationName = scanner.nextLine();
        return CommonValidator.validateIsStationNameExists(downEndStationName);
    }

    private static Station getEndStationNameInput(Scanner scanner) throws IllegalArgumentException {
        LineManagementPrinter.printLineUpEndStationNameInputMessage();
        String upEndStationName = scanner.nextLine();
        return CommonValidator.validateIsStationNameExists(upEndStationName);
    }

    private static String getNewLineNameInput(Scanner scanner) throws IllegalArgumentException {
        LineManagementPrinter.printNewLineNameInputMessage();
        String newLineName = scanner.nextLine();
        LineManagementValidator.validateIsLineNameLengthMinLengthOrMore(newLineName);
        LineManagementValidator.validateIsLineNameNotExists(newLineName);
        return newLineName;
    }

    public static void deleteLine(Scanner scanner) throws IllegalArgumentException {
        LineManagementPrinter.printLineNameToDeleteInputMessage();
        String lineNameToDeleteInput = scanner.nextLine();
        CommonValidator.validateIsLineNameExists(lineNameToDeleteInput);
        LineStationMappingRepository.deleteLine(lineNameToDeleteInput);
        LineManagementPrinter.printLineDeleteSuccessMessage();
    }

    public static void printLineList() {
        LineManagementPrinter.printLineListTitle();
        LineRepository.printAllLines();
    }
}
