package subway.domain.station;

import java.util.Scanner;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.common.ErrorMessage;
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
            String input = menuInputManager.getStationInput();
            if (input.equals(MenuKeys.BACK.getKey())) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals(MenuKeys.ONE.getKey())) {
            addStation();
        }
        if (input.equals(MenuKeys.TWO.getKey())) {
            deleteStation();
        }
        if (input.equals(MenuKeys.THREE.getKey())) {
            lookStations();
        }
    }

    private void addStation() {
        try {
            String name = stationInputManager.getStationNameToAdd();
            StationRepository.addStation(new Station(name));
            StationOutputManager.printAddedInfo();
        } catch (ErrorMessage errorMessage) {
            StationOutputManager.printErrorMessage(errorMessage);
        }
    }

    private void deleteStation() {
        try {
            String name = stationInputManager.getStationNameToDelete();
            StationRepository.deleteStation(name);
            StationOutputManager.printDeletedInfo();
        } catch (ErrorMessage errorMessage) {
            StationOutputManager.printErrorMessage(errorMessage);
        }
    }

    private void lookStations() {
        StationOutputManager.printStations();
    }

}
