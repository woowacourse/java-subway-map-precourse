package subway.domain;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class SubwayManager {
    public void startProgram(Scanner scanner) {
        State state = State.MAIN_SCENE;

        do {
            state = setSceneState(state, scanner);
            state = setStationState(state, scanner);
            state = setLineState(state, scanner);
            state = setSectionState(state, scanner);
            state = setMapState(state);
        } while (state != State.QUIT);
    }

    public State setSceneState(State state, Scanner scanner) {
        state = showMainScene(state, scanner);
        state = showStationScene(state, scanner);
        state = showLineScene(state, scanner);
        state = showSectionScene(state, scanner);

        return state;
    }

    public State setStationState(State state, Scanner scanner) {
        state = StationManager.addStation(state, scanner);
        state = StationManager.removeStation(state, scanner);
        state = StationManager.inquiryStation(state);

        return state;
    }

    public State setLineState(State state, Scanner scanner) {
        state = LineManager.addLine(state, scanner);
        state = LineManager.removeLine(state, scanner);
        state = LineManager.inquiryLine(state);

        return state;
    }

    public State setSectionState(State state, Scanner scanner) {
        state = registerSection(state, scanner);
        state = removeSection(state, scanner);

        return state;
    }

    public State setMapState(State state) {
        state = inquirySubwayMap(state);

        return state;
    }

    public State showMainScene(State state, Scanner scanner) {
        if (state.equals(State.MAIN_SCENE)) {
            OutputView.printMainScene();
            OutputView.printChoiceFunction();

            return InputView.inputMainSceneChoice(scanner);
        }

        return state;
    }

    public State showStationScene(State state, Scanner scanner) {
        if (state.equals(State.STATION_SCENE)) {
            OutputView.printStationManagementScene();
            OutputView.printChoiceFunction();

            return InputView.inputStationSceneChoice(scanner);
        }

        return state;
    }

    public State showLineScene(State state, Scanner scanner) {
        if (state.equals(State.LINE_SCENE)) {
            OutputView.printLineScene();
            OutputView.printChoiceFunction();

            return InputView.inputLineSceneChoice(scanner);
        }

        return state;
    }

    public State showSectionScene(State state, Scanner scanner) {
        if (state.equals(State.SECTION_SCENE)) {
            OutputView.printSectionScene();
            OutputView.printChoiceFunction();

            return InputView.inputSectionSceneChoice(scanner);
        }

        return state;
    }

    public State registerSection(State state, Scanner scanner) {
        if (state.equals(State.SECTION_ADD)) {
            registerSection(scanner);

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void registerSection(Scanner scanner) {
        OutputView.printInputLine();
        Line line = findLineToRegister(InputView.inputLineName(scanner));

        OutputView.printInputStation();
        Station station = findStationToRegister(InputView.inputStationName(scanner));

        OutputView.printInputOrder();
        int index = InputView.inputStationIndex(scanner);

        line.addStation(station, index);

        OutputView.printRegisteredSectionMessage();
    }
    
    public State removeSection(State state, Scanner scanner) {
        if (state.equals(State.SECTION_REMOVE)) {
            removeSection(scanner);

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void removeSection(Scanner scanner) {
        findLineToRemove(scanner).deleteStation(findStationToRemove(scanner).getName());
        OutputView.printRemovedSectionMessage();
    }

    private Line findLineToRegister(String name) {
        return LineRepository.findLineByName(name);
    }

    private Station findStationToRegister(String name) {
        return StationRepository.findStationByName(name);
    }

    private Line findLineToRemove(Scanner scanner) {
        OutputView.printInputRemoveSectionLine();

        return LineRepository.findLineByName(InputView.inputLineName(scanner));
    }

    private Station findStationToRemove(Scanner scanner) {
        OutputView.printInputRemoveSectionStation();

        return StationRepository.findStationByName(InputView.inputStationName(scanner));
    }

    public State inquirySubwayMap(State state) {
        if (state.equals(State.MAP_SCENE)) {
            OutputView.printSubwayMapMessage();
            List<Line> lines = LineRepository.lines();
            lines.forEach(OutputView::printSubwayMap);

            return State.MAIN_SCENE;
        }

        return state;
    }
}
