package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.State;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionManager {
    public State registerSection(State state, Scanner scanner) {
        if (state == State.SECTION_ADD) {
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
        if (state == State.SECTION_REMOVE) {
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
}
