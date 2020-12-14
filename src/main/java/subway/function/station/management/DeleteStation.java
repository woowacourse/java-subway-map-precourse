package subway.function.station.management;

import java.util.Scanner;
import subway.domain.station.StationRepository;
import subway.function.station.printer.StationManagementPrinter;
import subway.function.station.validator.StationManagementValidator;

public class DeleteStation {
    public static void deleteStation(Scanner scanner) throws IllegalArgumentException {
        StationManagementPrinter.printUserInputStationToDeleteMessage();
        String stationName = scanner.nextLine();
        StationManagementValidator.validateStationNameToDelete(stationName);
        StationRepository.deleteStation(stationName);
        StationManagementPrinter.printDeleteStationSuccessMessage();
    }
}
