package subway.userinterface.stationmenu;

import subway.service.StationService;
import subway.userinterface.Menu;
import subway.userinterface.OutputController;

import java.util.Scanner;

public class StationDeleteController implements Menu {

    private final static String MENU_NAME = "2. 역 삭제";
    private final static String MENU_KEY = "2";
    private final static String STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.";
    private final static StationService stationService = new StationService();
    private final static StationDeleteInputController stationDeleteInputController
            = new StationDeleteInputController();
    private static StationDeleteController stationDeleteController;

    private StationDeleteController() {}

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
        String deleteStation;
        deleteStation = stationDeleteInputController.getUserInput(scanner);

        stationService.deleteStation(deleteStation);

        OutputController.printInfo(STATION_DELETED);
    }

    public static Menu getInstance() {
        if (stationDeleteController == null) {
            stationDeleteController = new StationDeleteController();
        }

        return stationDeleteController;
    }
}
