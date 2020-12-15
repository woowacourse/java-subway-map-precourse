package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationScreen;

public class StationController implements Controller {
    private static final String USER_ANSWER_REGISTER = "1";
    private static final String USER_ANSWER_DELETE = "2";
    private static final String USER_ANSWER_SHOW = "3";
    private static final String BACK = "B";

    static StationController instance;
    private final StationScreen screen;

    public StationController() {
        screen = StationScreen.getInstance();
    }

    public static StationController getInstance() {
        if (instance == null) {
            instance = new StationController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(USER_ANSWER_REGISTER)) {
            registerStation();
        }
        if (userInput.equals(USER_ANSWER_DELETE)) {
            deleteStation();
        }
        if (userInput.equals(USER_ANSWER_SHOW)) {
            screen.printStationsList();
        }
        if (userInput.equals(BACK)) {
            MainController.getInstance().action();
        }
        action();
    }

    private void registerStation() {
        String userInput = screen.showPromptRegisterStation();
        try {
            StationRepository.addStation(new Station(userInput));
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            registerStation();
        }
        screen.printRegistrationCompleted();
    }

    private void deleteStation() {
        String userInput = screen.showPromptDeleteStation();
        try {
            StationRepository.deleteStation(userInput);
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            return;
        }
        screen.printDeletionCompleted();
    }
}

