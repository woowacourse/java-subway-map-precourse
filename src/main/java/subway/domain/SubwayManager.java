package subway.domain;

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
        } while (state != State.QUIT);
    }

    public State showMainScene(State state, Scanner scanner) {
        if (state.equals(State.MAIN_SCENE)) {
            OutputView.printMainScene();
            OutputView.printChoiceFunction();
        }

        return InputView.inputMainSceneChoice(scanner);
    }

    public State showStationScene(State state, Scanner scanner) {
        if (state.equals(State.STATION_SCENE)) {
            OutputView.printStationManagementScene();
            OutputView.printChoiceFunction();
        }

        return InputView.inputStationSceneChoice(scanner);
    }

    public State showLineScene(State state, Scanner scanner) {
        if (state.equals(State.LINE_SCENE)) {
            OutputView.printLineScene();
            OutputView.printChoiceFunction();
        }

        return null;
    }

    public State showSectionScene(State state, Scanner scanner) {
        if (state.equals(State.SECTION_SCENE)) {
            OutputView.printSectionScene();
            OutputView.printChoiceFunction();
        }

        return null;
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public void removeStation(String name) {
        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public void inquiryStation() {
        OutputView.printStationList(StationRepository.stations());
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

    public void removeLine(String name) {
        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }
    
    public void inquiryLine() {
        OutputView.printLineList(LineRepository.lines());
    }

    public void registerSection(Scanner scanner) {
        findLineToRegister(
                scanner.next()).addStation(findStationToRegister(scanner.next()), getRegisterIndex(scanner.next()));
        OutputView.printRegisteredSectionMessage();
    }

    public void removeSection(Scanner scanner) {
        findLineToRemove(scanner.next()).deleteStation(findStationToRemove(scanner.next()).getName());
        OutputView.printRemovedSectionMessage();
    }

    private Line findLineToRegister(String name) {
        OutputView.printInputLine();

        return LineRepository.findLineByName(name);
    }

    private Station findStationToRegister(String name) {
        OutputView.printInputStation();

        return StationRepository.findStationByName(name);
    }

    private Line findLineToRemove(String name) {
        OutputView.printInputRemoveSectionLine();

        return LineRepository.findLineByName(name);
    }

    private Station findStationToRemove(String name) {
        OutputView.printInputRemoveSectionStation();

        return StationRepository.findStationByName(name);
    }

    private int getRegisterIndex(String index) {
        return Integer.parseInt(index);
    }

    public void inquirySubwayMap() {
        LineRepository.lines().forEach(OutputView::printSubwayMap);
    }
}
