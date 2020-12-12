package subway.controller;

import subway.view.InputView;
import subway.view.MapScreen;
import subway.view.OutputView;

public class MainMenu {
    public static void print() {
        OutputView.printMainMenu();
        String selection = InputView.receiveMenu("Main");
        if (selection.equals("1")) {
            StationMenu.goToStationMenu();
        }
        if (selection.equals("2")) {
            LineMenu.goToLineMenu();
        }
        if (selection.equals("3")) {
            SectionMenu.print();
        }
        if (selection.equals("4")) {
            MapScreen.print();
        }
        if (selection.equals("Q")) {
        }
    }
}
