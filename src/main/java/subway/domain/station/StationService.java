package subway.domain.station;

import java.util.Scanner;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuItemsRepository;
import subway.common.ErrorMessage;
import subway.common.InfoMessage;
import subway.common.Guide;

public class StationService {
    private MenuInputManager menuInputManager;
    private StationInputManager stationInputManager;

    public StationService(Scanner scanner, MenuInputManager menuInputManager) {
        this.menuInputManager = menuInputManager;
        stationInputManager = new StationInputManager(scanner);

    }

    public void run() {
        while (true) {
            Guide.printMenu(MenuItemsRepository.getStationItems());
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

    private void lookupStations() {
        for (Station station : StationRepository.stations()) {
            InfoMessage.printName(station.getName());
        }
    }

    private void deleteStation() {
        String name = stationInputManager.getStationNameToDelete();
        if (name.contains(ErrorMessage.OUT)) {
            return;
        }
        StationRepository.deleteStation(name);
        InfoMessage.printStationDeleted();
    }

    private void addStation() {
        String name = stationInputManager.getStationNameToAdd("등록할");
        Station station = new Station(name);
        StationRepository.addStation(station);
        InfoMessage.printStationAdded();

    }


}
