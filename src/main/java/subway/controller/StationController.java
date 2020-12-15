package subway.controller;

import java.util.Scanner;
import subway.view.DetailView;
import utils.Category;

public class StationController {

    private static final Category category = Category.STATION;
    private StationController() {}

    public static void startStationManagement(Scanner scanner, int selection) {
        DetailView stationView = new DetailView(category);
    }
}
