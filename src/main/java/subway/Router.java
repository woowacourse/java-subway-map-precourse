package subway;

import java.util.Scanner;
import subway.util.LineManagementScreen;
import subway.util.MainScreen;
import subway.util.SectionManagementScreen;
import subway.util.StationManagementScreen;
import subway.view.InputView;
import subway.view.OutputView;

public class Router {
    private static final Boolean BACK_TO_UPPER_SCREEN = true;

    private static InputView inputView;

    public Router(Scanner scanner) {
        this.inputView = new InputView(scanner);
    }

    public void run() {
        String command;
        do {
            command = inputView.getScreenCommand("MAIN_SCREEN", OutputView.MAIN_SCREEN);
        } while (routeMainScreen(command));
    }

    private boolean routeMainScreen(String command) {
        return MainScreen.run(command);
    }

    public static boolean enterStationManagementScreen() {
        String command = inputView.getScreenCommand("STATION_MANAGEMENT_SCREEN"
            , OutputView.STATION_MANAGEMENT_SCREEN);

        if (routeStationManagementScreen(command)) {
            return enterStationManagementScreen();
        }
        return BACK_TO_UPPER_SCREEN;
    }

    public static boolean enterLineManagementScreen() {
        String command = inputView.getScreenCommand("LINE_MANAGEMENT_SCREEN"
            , OutputView.LINE_MANAGEMENT_SCREEN);

        if (routeLineManagementScreen(command)) {
            return enterLineManagementScreen();
        }
        return BACK_TO_UPPER_SCREEN;
    }

    public static boolean enterSectionManagementScreen() {
        String command = inputView.getScreenCommand("SECTION_MANAGEMENT_SCREEN"
            , OutputView.SECTION_MANAGEMENT_SCREEN);

        if (routeSectionManagementScreen(command)) {
            return enterSectionManagementScreen();
        }
        return BACK_TO_UPPER_SCREEN;
    }

    public static boolean routeStationManagementScreen(String command) {
        return StationManagementScreen.run(inputView, command);
    }

    public static boolean routeLineManagementScreen(String command) {
        return LineManagementScreen.run(inputView, command);
    }

    public static boolean routeSectionManagementScreen(String command) {
        return SectionManagementScreen.run(inputView,command);
    }
}