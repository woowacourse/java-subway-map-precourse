package subway.controller;

import subway.view.MainScreen;

public class MainController implements Controller {
    private static final String USER_ANSWER_STATION_MANAGEMENT_SCREEN = "1";
    private static final String USER_ANSWER_LINE_MANAGEMENT_SCREEN = "2";
    private static final String USER_ANSWER_SECTION_MANAGEMENT_SCREEN = "3";
    private static final String USER_ANSWER_PRINT_TRANSIT_MAP = "4";
    private static final String QUIT = "Q";

    static MainController instance;
    private final MainScreen screen;

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
        if (userInput.equals(USER_ANSWER_STATION_MANAGEMENT_SCREEN)) {
            StationController.getInstance().action();
        }
        if (userInput.equals(USER_ANSWER_LINE_MANAGEMENT_SCREEN)) {
            LineController.getInstance().action();
        }
        if (userInput.equals(USER_ANSWER_SECTION_MANAGEMENT_SCREEN)) {
            SectionController.getInstance().action();
        }
        if (userInput.equals(USER_ANSWER_PRINT_TRANSIT_MAP)) {
            screen.printTransitMap();
            action();
        }
        if (userInput.equals(QUIT)) {
            System.exit(0);
        }
    }
}
