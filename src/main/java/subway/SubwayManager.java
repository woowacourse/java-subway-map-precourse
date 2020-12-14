package subway;

import java.util.Scanner;
import controller.StationManageController;
import view.MainView;
import view.StationManageView;

public class SubwayManager {
    public static final int INPUT_MANAGE_STATION = 1;
    public static final int INPUT_MANAGE_LINE = 2;
    public static final int INPUT_MANAGE_SECTION = 3;
    public static final int INPUT_PRINT_LINES = 4;
    public static final String INPUT_QUIT = "Q";

    private MainView mainView;
    private StationManageView stationManageView;

    public SubwayManager(Scanner scanner) {
        mainView = new MainView(scanner);

        stationManageView = new StationManageView(scanner);
        StationManageController stationManagerController =
                new StationManageController(stationManageView);
        stationManageView.setController(stationManagerController);
    }

    public void run() {
        while (true) {
            mainView.run();
            String input = mainView.input();
            if (input.equals(INPUT_QUIT)) {
                break;
            }
            processInput(Integer.valueOf(input));
        }
    }

    private void processInput(int input) {
        if (input == INPUT_MANAGE_STATION) {
            stationManageView.run();
        }
    }
}
