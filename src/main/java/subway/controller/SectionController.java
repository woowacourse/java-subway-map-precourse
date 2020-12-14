package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.SectionScreen;
import subway.view.InputView;

import java.util.ArrayList;

public class SectionController implements Controller {
    private static final String USER_ANSWER_REGISTER = "1";
    private static final String USER_ANSWER_DELETE = "2";
    private static final String BACK = "B";

    static SectionController instance;
    private SectionScreen screen;

    public SectionController() {
        screen = SectionScreen.getInstance();
    }

    public static SectionController getInstance() {
        if (instance == null) {
            instance = new SectionController();
        }
        return instance;
    }

    @Override
    public void action() {
        String userInput = screen.show();
        if (userInput.equals(USER_ANSWER_REGISTER)) {
            registerSection();
        }
        if (userInput.equals(USER_ANSWER_DELETE)) {
            deleteSection();
        }
        if (userInput.equals(BACK)) {
            MainController.getInstance().action();
        }
        action();
    }

    private void registerSection() {
        String userInput = screen.showPromptRegisterSection();
        try {
            registerSectionHelper(userInput);
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            return;
        }
        screen.printRegistrationCompleted();
    }

    private void registerSectionHelper(String userInput) {
        Line line = LineRepository.findLine(userInput);
        Station station = getStationToAdd();
        if (line.contains(station)) {
            throw new IllegalArgumentException();
        }
        int section = getSectionToAdd(line.getLineStations()) - 1;
        line.getLineStations().add(section, station);
    }

    private Station getStationToAdd() {
        screen.printStationToAdd();
        return StationRepository.findStation(InputView.getUserInput());
    }

    private int getSectionToAdd(ArrayList<Station> lineStations) {
        screen.printSectionToAdd();
        int section = Integer.parseInt(InputView.getUserInput());
        if (section > lineStations.size() - 1 || section <= 0) {
            throw new IllegalArgumentException();
        }
        return section;
    }

    private void deleteSection() {
        String userInput = screen.showPromptDeleteSection();
        try {
            deleteSectionHelper(userInput);
        } catch (IllegalArgumentException e) {
            screen.printError(e);
            return;
        }
        screen.printDeletionCompleted();
    }

    private void deleteSectionHelper(String userInput) {
        Line line = LineRepository.findLine(userInput);
        if (line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Station station = screen.showPromptStationToDelete();
        if (!line.contains(station)) {
            throw new IllegalArgumentException();
        }
        line.removeLineStation(station);
    }
}
