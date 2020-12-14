package subway.domain.line;

import subway.domain.State;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.AlreadyExistLineException;
import subway.exception.NoSuchLineException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineManager {
    public State addLine(State state, Scanner scanner) {
        if (state.equals(State.LINE_ADD)) {
            OutputView.printInputRegisterLine();
            addLine(InputView.inputLineName(scanner), scanner);

            return State.MAIN_SCENE;
        }

        return state;
    }

    public void addLine(String name, Scanner scanner) {
        if (LineRepository.isExistLine(name)) {
            throw new AlreadyExistLineException();
        }

        Line line = new Line(name);

        line.initializeSectionStation(setLineUpStation(scanner), setLineDownStation(scanner));

        LineRepository.addLine(line);
        OutputView.printRegisteredLineMessage();
    }

    private Station setLineUpStation(Scanner scanner) {
        OutputView.printInputRegisterLineUpStation();

        return StationRepository.findStationByName(scanner.next());
    }

    private Station setLineDownStation(Scanner scanner) {
        OutputView.printInputRegisterLineDownStation();

        return StationRepository.findStationByName(scanner.next());
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
        if (!LineRepository.isExistLine(name)) {
            throw new NoSuchLineException();
        }

        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }

    public State showLine(State state) {
        if (state.equals(State.LINE_INQUIRY)) {
            OutputView.printLineList(LineRepository.lines());

            return State.MAIN_SCENE;
        }

        return state;
    }
}
