package subway.domain.station;

import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.common.ErrorMessageException;
import subway.domain.menu.MenuKeys;
import subway.domain.menu.MenuOutputManager;

public class StationService {
    private final MenuInputManager menuInputManager;
    private final StationInputManager stationInputManager;

    public StationService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        stationInputManager = new StationInputManager(scanner);

    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(Menu.STATION);
            String inputKey = menuInputManager.getStationInput();
            if (inputKey.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            addStation();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            deleteStation();
        }
        if (inputKey.equals(MenuKeys.THREE.getKey())) {
            lookStations();
        }
    }

    private void addStation() {
        try {
            String name = stationInputManager.getStationNameToAdd();
            StationRepository.addStation(new Station(name));
            StationOutputManager.printAddedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

    private void deleteStation() {
        try {
            String name = stationInputManager.getStationNameToDelete();
            StationRepository.deleteStation(name);
            StationOutputManager.printDeletedInfo();
        } catch (ErrorMessageException errorMessageException) {
            ErrorMessage.print(errorMessageException);
        }
    }

    private void lookStations() {
        StationOutputManager.printStations();
    }

}
