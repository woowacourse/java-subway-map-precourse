package subway.domain;

import jdk.internal.util.xml.impl.Input;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    public void startProgram(Scanner scanner) {
        State state = State.MAIN_SCENE;

        do {
            state = showMainScene(state, scanner);
            state = showStationScene(state, scanner);
            state = showLineScene(state, scanner);
            state = showSectionScene(state, scanner);

            state = addStation(state, scanner);
            state = removeStation(state, scanner);
            state = inquiryStation(state);

            state = addLine(state, scanner);
            state = removeLine(state, scanner);
            state = inquiryLine(state);

            state = registerSection(state, scanner);
            state = removeSection(state, scanner);

            state = inquirySubwayMap(state);
        } while (state != State.QUIT);
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

    public State addStation(State state, Scanner scanner) {
        if (state.equals(State.STATION_ADD)) {
            OutputView.printInputStation();
            addStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public State removeStation(State state, Scanner scanner) {
        if (state.equals(State.STATION_REMOVE)) {
            OutputView.printInputRemoveStation();
            removeStation(InputView.inputStationName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void removeStation(String name) {
        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public State inquiryStation(State state) {
        if (state.equals(State.STATION_INQUIRY)) {
            OutputView.printStationList(StationRepository.stations());

            return State.MAIN_SCENE;
        }

        return state;
    }

    public State addLine(State state, Scanner scanner) {
        if (state.equals(State.LINE_ADD)) {
            OutputView.printInputRegisterLine();
            addLine(InputView.inputLineName(scanner), scanner);

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void addLine(String name, Scanner scanner) {
        Line line = new Line(name);

        setLineUpStation(line, scanner);
        setLineDownStation(line, scanner);

        LineRepository.addLine(line);
        OutputView.printRegisteredLineMessage();
    }

    private void setLineUpStation(Line line, Scanner scanner) {
        OutputView.printInputRegisterLineUpStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));
    }

    private void setLineDownStation(Line line, Scanner scanner) {
        OutputView.printInputRegisterLineDownStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));
    }
    
    public State removeLine(State state, Scanner scanner) {
        if (state.equals(State.LINE_REMOVE)) {
            OutputView.printInputRemoveLine();
            removeLine(InputView.inputLineName(scanner));

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void removeLine(String name) {
        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }
    
    public State inquiryLine(State state) {
        if (state.equals(State.LINE_INQUIRY)) {
            OutputView.printLineList(LineRepository.lines());

            return State.MAIN_SCENE;
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
            LineRepository.lines().forEach(OutputView::printSubwayMap);

            return State.MAIN_SCENE;
        }

        return state;
    }
}
