package subway.controller;

import subway.Constants;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationScreen;

public class StationController implements Controller {
    static StationController instance;
    StationScreen screen;

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
        if (userInput.equals(Constants.USER_ANSWER_REGISTER)) {
            registerStation();
        }
        if (userInput.equals(Constants.USER_ANSWER_DELETE)) {
            deleteStation();
        }
        if (userInput.equals(Constants.USER_ANSWER_SHOW)) {
            screen.printStationsList();
        }
        MainController.getInstance().action();
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

