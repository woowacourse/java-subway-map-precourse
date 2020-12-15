package subway.controller;

import java.util.Scanner;
import subway.domain.service.StationService;
import subway.view.DetailView;
import utils.Category;

public class StationController {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    public static final int GET_LIST = 3;

    private static final Category category = Category.STATION;
    public static DetailView stationView = new DetailView(category);

    private StationController() {}

    public static void manageStation(Scanner scanner, int selection) {
        if (selection == GET_LIST) {
            StationService.readStationList();
            return;
        }
        stationView.ask(selection);
        String answer = stationView.inputName(scanner, selection);
        if (answer == null) {
            return;
        }
        if (selection == ADD) {
            StationService.createStation(answer);
            return;
        }
        StationService.deleteStation(answer);
    }
}
