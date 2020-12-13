package subway.domain.station;

import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.common.Guide;

public class StationInputManager {
    private Scanner scanner;

    public StationInputManager(Scanner scanner) {
        this.scanner = scanner;
    }


    public String getStationNameToDelete() {
        Guide.print(StationOutputManager.STATION_DELETE_GUIDE);
        String name = scanner.nextLine().trim();
        if (!checkNameToDelete(name)) {
            return ErrorMessage.OUT;
        }
        return name;
    }

    private boolean checkNameToDelete(String name) {
        return checkAlreadyExist(name) && checkNotOnPath(name);
    }

    private boolean checkNotOnPath(String name) {
        if (StationRepository.findStation(name).isOnPath()) {
            ErrorMessage.printNotDeleteOnPathStation();
            return false;
        }
        return true;
    }

    public String getStationNameToAdd() {
        while (true) {
            Guide.print(StationOutputManager.STATION_ADD_GUIDE);
            String name = scanner.nextLine().trim();
            if (!checkName(name)) {
                continue;
            }
            return name;
        }
    }

    private boolean checkName(String name) {
        return checkLength(name) && checkLastLetter(name) && checkNotAlreadyExist(name);
    }

    private boolean checkNotAlreadyExist(String name) {
        if (StationRepository.stationNames().contains(name)) {
            ErrorMessage.printValueAlreadyExist();
            return false;
        }
        return true;
    }

    private boolean checkAlreadyExist(String name) {
        if (!StationRepository.stationNames().contains(name)) {
            ErrorMessage.printNotExistStation();
            return false;
        }
        return true;
    }

    private boolean checkLastLetter(String name) {
        if (name.charAt(name.length() - 1) != '역') {
            ErrorMessage.printLastLetterStation();
            return false;
        }
        return true;
    }

    private boolean checkLength(String name) {
        if (name.length() < 2) {
            ErrorMessage.printNameLength();
            return false;
        }
        return true;
    }

}
