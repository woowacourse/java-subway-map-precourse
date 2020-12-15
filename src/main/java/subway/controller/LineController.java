package subway.controller;

import subway.domain.*;
import subway.view.LineScreen;

public class LineController implements Controller {
    private static final String USER_ANSWER_REGISTER = "1";
    private static final String USER_ANSWER_DELETE = "2";
    private static final String USER_ANSWER_SHOW = "3";
    private static final String BACK = "B";

    static LineController instance;
    private final LineScreen screen;

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
        if (userInput.equals(USER_ANSWER_REGISTER)) {
            registerLine();
        }
        if (userInput.equals(USER_ANSWER_DELETE)) {
            deleteLine();
        }
        if (userInput.equals(USER_ANSWER_SHOW)) {
            screen.printLines();
        }
        if (userInput.equals(BACK)) {
            MainController.getInstance().action();
        }
        action();
    }

    private void registerLine() {
        String userInput = screen.showPromptRegisterLine();
        try {
            LineRepository.validateAlreadyExists(userInput);
            Line line = new Line(userInput);
            Section section = new Section();
            initiateSection(section);
            LineRepository.addLine(line);
            SectionRepository.addSection(line, section);
        } catch (Exception e) {
            screen.printError(e.getMessage());
            registerLine();
            return;
        }
        screen.printRegistrationCompleted();
    }

    private void initiateSection(Section section) {
        Station upstreamStation = null;
        Station downstreamStation = null;
        try {
            String userInputUpstreamStation = screen.showPromptUpstreamStation();
            upstreamStation = StationRepository.findStation(userInputUpstreamStation);

            String userInputDownstreamStation = screen.showPromptDownstreamStation();
            downstreamStation = StationRepository.findStation(userInputDownstreamStation);
            section.initiateSection(upstreamStation, downstreamStation);
        } catch (Exception e) {
            screen.printError(e.getMessage());
            initiateSection(section);
        }
    }

    private void deleteLine() {
        String userInput = screen.showPromptDeleteLine();
        try {
            Line lineToDelete = LineRepository.findLine(userInput);
            SectionRepository.deleteSection(lineToDelete);
            LineRepository.deleteLine(lineToDelete);
        } catch (Exception e) {
            screen.printError(e.getMessage());
            action();
            return;
        }
        screen.printDeletionCompleted();
    }
}
