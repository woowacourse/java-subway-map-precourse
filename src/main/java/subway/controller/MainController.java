package subway.controller;

import subway.Constants;
import subway.view.MainScreen;

public class MainController implements Controller {
    static MainController instance;
    private MainScreen screen;

    public MainController() {
        screen = MainScreen.getInstance();
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(Constants.USER_ANSWER_STATION_MANAGEMENT_SCREEN)) {
            StationController.getInstance().action();
        }
        if (userInput.equals(Constants.USER_ANSWER_LINE_MANAGEMENT_SCREEN)) {
            LineController.getInstance().action();
        }
        if (userInput.equals(Constants.USER_ANSWER_SECTION_MANAGEMENT_SCREEN)) {
            SectionController.getInstance().action();
        }
        if (userInput.equals(Constants.USER_ANSWER_PRINT_TRANSIT_MAP)) {
            screen.printTransitMap();
            action();
        }
        if (userInput.equals(Constants.QUIT)) {
            System.exit(0);
        }
    }
}
