package subway.controller;

import java.util.Scanner;
import subway.domain.service.StationService;
import subway.view.DetailView;
import utils.Category;

public class StationController {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    public static final int GET_LIST = 3;

    public static DetailView stationView = new DetailView(Category.STATION);

    private StationController() {}

    public static void manageStation(Scanner scanner, int selection) {
        if (selection == GET_LIST) {
            StationService.readStationList();
            return;
        }

        String name = stationView.ask(scanner, selection);
        if (name == null) {
            return;
        }
        if (selection == ADD) {
            StationService.createStation(name);
            return;
        }
        StationService.deleteStation(name);
    }
}
