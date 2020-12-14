package subway.function.line.management;

import java.util.Scanner;
import subway.common.validator.CommonValidator;
import subway.domain.LineStationMappingRepository;
import subway.domain.station.Station;
import subway.function.line.printer.LineManagementPrinter;
import subway.function.line.validator.LineManagementValidator;

public class RegisterNewLine {
    public static void registerNewLine(Scanner scanner) throws IllegalArgumentException {
        String newLineName = getNewLineNameInput(scanner);
        Station upEndStation = getEndStationNameInput(scanner);
        Station downEndStation = getDownEndStationNameInput(scanner);
        LineManagementValidator.validateIsNotEqual(upEndStation, downEndStation);
        LineStationMappingRepository
            .createNewLineByStations(newLineName, upEndStation, downEndStation);
        LineManagementPrinter.printNewLineRegistrationSuccessMessage();
    }

    private static Station getDownEndStationNameInput(Scanner scanner)
        throws IllegalArgumentException {
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
}
