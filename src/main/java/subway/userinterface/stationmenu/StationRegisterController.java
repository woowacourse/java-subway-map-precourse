package subway.userinterface.stationmenu;

import subway.service.StationService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;
import java.util.Scanner;

public class StationRegisterController implements Menu {
    private final static String MENU_NAME = "1. 역 등록";
    private final static String MENU_KEY = "1";
    private final static String STATION_REGISTERED = "\n[INFO] 지하철 역이 등록되었습니다.";
    private final static StationService stationService = new StationService();
    private final static StationRegisterInputController stationRegisterInputController
            = new StationRegisterInputController();
    private static StationRegisterController stationRegisterController;

    private StationRegisterController() {}

    public static Menu getInstance() {
        if (stationRegisterController == null) {
            stationRegisterController = new StationRegisterController();
        }
        return stationRegisterController;
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }

    @Override
    public String getMenuKey() {
        return MENU_KEY;
    }

    @Override
    public void run(Scanner scanner) throws IllegalArgumentException {
        stationService.registerStation(stationRegisterInputController.getUserInput(scanner));
        OutputController.printInfo(STATION_REGISTERED);
    }
}
