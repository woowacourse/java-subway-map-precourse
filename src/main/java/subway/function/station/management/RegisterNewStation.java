package subway.function.station.management;

import java.util.Scanner;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.function.station.printer.StationManagementPrinter;
import subway.function.station.validator.StationManagementValidator;

public class RegisterNewStation {
    public static void registerNewStation(Scanner scanner) throws IllegalArgumentException {
        StationManagementPrinter.printUserInputStationRegistrationMessage();
        String newStationName = scanner.nextLine();
        StationManagementValidator.validateStationNameToRegister(newStationName);
        StationRepository.addStation(new Station(newStationName));
        StationManagementPrinter.printRegisterNewStationSuccessMessage();
    }
}
