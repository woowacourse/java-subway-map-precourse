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
            String inputKey = menuInputManager.getMainInput();
            if (inputKey.equals(MenuKeys.EXIT.getKey())) {
                return;
            }
            runSystemByInput(inputKey);
        }
    }

    private void runSystemByInput(String inputKey) {
        if (inputKey.equals(MenuKeys.ONE.getKey())) {
            stationService.run();
        }
        if (inputKey.equals(MenuKeys.TWO.getKey())) {
            lineService.run();
        }
        if (inputKey.equals(MenuKeys.THREE.getKey())) {
            pathService.run();
        }
        if (inputKey.equals(MenuKeys.FOUR.getKey())) {
            SubwayOutputManager.printSubwayMap();
        }
    }

}
