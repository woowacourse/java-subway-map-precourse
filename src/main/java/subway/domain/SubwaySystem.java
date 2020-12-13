package subway.domain;

import java.util.Scanner;
import subway.domain.menu.MenuItemsRepository;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuOutputManager;
import subway.domain.path.PathService;
import subway.domain.line.LineService;
import subway.domain.station.StationService;

public class SubwaySystem {
    private final MenuInputManager menuInputManager;
    private final StationService stationService;
    private final LineService lineService;
    private final PathService pathService;

    public SubwaySystem(Scanner scanner) {
        menuInputManager = new MenuInputManager(scanner);
        stationService = new StationService(scanner, menuInputManager);
        lineService = new LineService(scanner, menuInputManager);
        pathService = new PathService(scanner, menuInputManager);
        initInfo();
    }

    private void initInfo() {
        new InitialInfo();
    }

    public void run() {
        while (true) {
            MenuOutputManager.printMenu(MenuItemsRepository.getMainItems());
            String input = menuInputManager.getMainInput();
            if (input.equals("Q")) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals("1")) {
            stationService.run();
        }
        if (input.equals("2")) {
            lineService.run();
        }
        if (input.equals("3")) {
            pathService.run();
        }
        if (input.equals("4")) {
            SubwayOutputManager.printSubwayMap();
        }
    }

}
