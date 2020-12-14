package subway.domain;

import java.util.Scanner;
import subway.domain.menu.Menu;
import subway.domain.menu.MenuInputManager;
import subway.domain.menu.MenuKeys;
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
            MenuOutputManager.printMenu(Menu.MAIN);
            String input = menuInputManager.getMainInput();
            if (input.equals(MenuKeys.EXIT.getKey())) {
                return;
            }
            runSystemByInput(input);
        }
    }

    private void runSystemByInput(String input) {
        if (input.equals(MenuKeys.ONE.getKey())) {
            stationService.run();
        }
        if (input.equals(MenuKeys.TWO.getKey())) {
            lineService.run();
        }
        if (input.equals(MenuKeys.THREE.getKey())) {
            pathService.run();
        }
        if (input.equals(MenuKeys.FOUR.getKey())) {
            SubwayOutputManager.printSubwayMap();
        }
    }

}
