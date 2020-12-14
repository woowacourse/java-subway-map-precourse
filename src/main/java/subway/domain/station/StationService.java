package subway.domain.station;

import java.util.Scanner;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuItemsRepository;
import subway.common.ErrorMessage;
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
            MenuOutputManager.printMenu(MenuItemsRepository.getStationItems());
            String input = menuInputManager.getStationInput();
            if (input.equals("B")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            addStation();
        }
        if (input.equals("2")) {
            deleteStation();
        }
        if (input.equals("3")) {
            lookupStations();
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

    private void lookupStations() {
        StationOutputManager.printStations();
    }

}
