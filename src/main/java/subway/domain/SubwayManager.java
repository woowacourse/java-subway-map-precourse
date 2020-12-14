package subway.domain;

import subway.domain.line.Line;
import subway.domain.line.LineManager;
import subway.domain.line.LineRepository;
import subway.domain.section.SectionManager;
import subway.domain.station.StationManager;
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
        StationManager stationManager = new StationManager();

        state = stationManager.addStation(state, scanner);
        state = stationManager.removeStation(state, scanner);
        state = stationManager.showStation(state);

        return state;
    }

    public State setLineState(State state, Scanner scanner) {
        LineManager lineManager = new LineManager();

        state = lineManager.addLine(state, scanner);
        state = lineManager.removeLine(state, scanner);
        state = lineManager.showLine(state);

        return state;
    }

    public State setSectionState(State state, Scanner scanner) {
        SectionManager sectionManager = new SectionManager();

        state = sectionManager.registerSection(state, scanner);
        state = sectionManager.removeSection(state, scanner);

        return state;
    }

    public State setMapState(State state) {
        state = showSubwayMap(state);

        return state;
    }

    public State showMainScene(State state, Scanner scanner) {
        if (state == State.MAIN_SCENE) {
            OutputView.printMainScene();
            OutputView.printChoiceFunction();

            return InputView.inputMainSceneChoice(scanner);
        }

        return state;
    }

    public State showStationScene(State state, Scanner scanner) {
        if (state == State.STATION_SCENE) {
            OutputView.printStationManagementScene();
            OutputView.printChoiceFunction();

            return InputView.inputStationSceneChoice(scanner);
        }

        return state;
    }

    public State showLineScene(State state, Scanner scanner) {
        if (state == State.LINE_SCENE) {
            OutputView.printLineScene();
            OutputView.printChoiceFunction();

            return InputView.inputLineSceneChoice(scanner);
        }

        return state;
    }

    public State showSectionScene(State state, Scanner scanner) {
        if (state == State.SECTION_SCENE) {
            OutputView.printSectionScene();
            OutputView.printChoiceFunction();

            return InputView.inputSectionSceneChoice(scanner);
        }

        return state;
    }

    public State showSubwayMap(State state) {
        if (state == State.MAP_SCENE) {
            OutputView.printSubwayMapMessage();
            List<Line> lines = LineRepository.lines();
            lines.forEach(OutputView::printSubwayMap);

            return State.MAIN_SCENE;
        }

        return state;
    }
}
