package subway.controller;

import subway.Constants;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.LineScreen;

public class LineController implements Controller {
    static LineController instance;
    LineScreen screen;

    public LineController() {
        screen = LineScreen.getInstance();
    }

    public static LineController getInstance() {
        if (instance == null) {
            instance = new LineController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(Constants.USER_ANSWER_REGISTER)) {
            registerLine();
        }
        if (userInput.equals(Constants.USER_ANSWER_DELETE)) {
            deleteLine();
        }
        if (userInput.equals(Constants.USER_ANSWER_SHOW)) {
            screen.printLines();
        }
        if (userInput.equals(Constants.BACK)) {
            MainController.getInstance().action();
        }
        action();
    }

    private void registerLine() {
        String userInput = screen.showPromptRegisterLine();
        try {
            Line line = new Line(userInput);
            initiateLineStations(line);
            LineRepository.addLine(line);
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            registerLine();
            return;
        }
        screen.printRegistrationCompleted();
    }

    private void initiateLineStations(Line line) {
        Station upstreamStation = null;
        Station downstreamStation = null;
        try {
            String userInputUpstreamStation = screen.showPromptUpstreamStation();
            upstreamStation = StationRepository.findStation(userInputUpstreamStation);

            String userInputDownstreamStation = screen.showPromptDownstreamStation();
            downstreamStation = StationRepository.findStation(userInputDownstreamStation);
        } catch (Exception e) {
            screen.printError(e);
            initiateLineStations(line);
        }
        line.initiateLineStations(upstreamStation, downstreamStation);
    }

    private void deleteLine() {
        String userInput = screen.showPromptDeleteLine();
        try {
            LineRepository.deleteLineByName(userInput);
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            return;
        }
        screen.printDeletionCompleted();
    }
}
