package subway.view;

import subway.view.line.LineMenuInputView;
import subway.view.main.MainMenuInputView;
import subway.view.route.RouteMenuInputView;
import subway.view.station.StationMenuInputView;

import java.util.Scanner;

public class InputView {

    public static void menuRun(Scanner scanner) {
        String menuChooseResult = MainMenuInputView.getMainMenuCommand(scanner);
        while (true) {
            if (menuChooseResult.equals("1")) {
                if (StationMenuInputView.getStationMenuCommand(scanner).equals("B")) {
                    MainMenuInputView.getMainMenuCommand(scanner);
                }
                StationMenuInputView.getStationMenuCommand(scanner);
            }
            if (menuChooseResult.equals("2")) {
                if (LineMenuInputView.getLineMenuCommand(scanner).equals("B")) {
                    MainMenuInputView.getMainMenuCommand(scanner);
                }
                LineMenuInputView.getLineMenuCommand(scanner);
            }
            if (menuChooseResult.equals("3")) {
                if (RouteMenuInputView.getRouteMenuCommand(scanner).equals("B")) {
                    MainMenuInputView.getMainMenuCommand(scanner);
                }
                RouteMenuInputView.getRouteMenuCommand(scanner);
            }
        }
    }
}
