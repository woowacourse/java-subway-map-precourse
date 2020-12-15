package subway.controller;

import subway.domain.*;
import subway.view.SectionScreen;
import subway.view.InputView;

import java.util.List;

public class SectionController implements Controller {
    private static final String USER_ANSWER_REGISTER = "1";
    private static final String USER_ANSWER_DELETE = "2";
    private static final String BACK = "B";

    static SectionController instance;
    private final SectionScreen screen;

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
        Section section = SectionRepository.findSection(line);
        Station station = getStationToAdd();

        if (section.contains(station)) {
            throw new IllegalArgumentException();
        }
        int indexToAdd = getIndexToAdd(section.getSection()) - 1;
        section.getSection().add(indexToAdd, station);
    }

    private Station getStationToAdd() {
        screen.printStationToAdd();
        return StationRepository.findStation(InputView.getUserInput());
    }

    private int getIndexToAdd(List<Station> section) {
        screen.printSectionToAdd();
        int indexToAdd = Integer.parseInt(InputView.getUserInput());
        if (indexToAdd > 0 || indexToAdd <= section.size()) {
            return indexToAdd;
        }
        throw new IllegalArgumentException();
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
        Section section = SectionRepository.findSection(line);
        if (section.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Station station = screen.showPromptStationToDelete();
        if (!section.contains(station)) {
            throw new IllegalArgumentException();
        }
        section.removeSection(station);
    }
}
