package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Action;

import java.util.Scanner;

public class StationController implements Controller {
    private static final String NAME = "역";
    Scanner scanner;

    @Override
    public void mappingCommandToValidFunction(int command, Scanner scanner) {
        this.scanner = scanner;
        if (command == Action.INSERT.getActionNumber()) {
            addStation(Action.INSERT.getAction());
            return;
        }
        if (command == Action.DELETE.getActionNumber()) {
            deleteStation(Action.DELETE.getAction());
            return;
        }
        if (command == Action.SELECT.getActionNumber()) {
            selectStation();
            return;
        }
    }

    private void addStation(String action) {
        OutputView.printWithAction(action, NAME);
        String station = InputView.getCommand(scanner);
        if (StationRepository.addStation(new Station(station))) {
            OutputView.printNewLine();
            OutputView.printAlert(action, NAME);
            return;
        }
    }

    private void deleteStation(String action) {
        OutputView.printWithAction(action, NAME);
        String station = InputView.getCommand(scanner);
        if(LineRepository.isStationInLine(new Station(station)) || !StationRepository.deleteStation(station)) {
            OutputView.printStationDeleteErrorMessage();
            return;
        }
        OutputView.printNewLine();
        OutputView.printAlert(action, NAME);
    }

    private void selectStation() {
        OutputView.printNewLine();
        OutputView.printList(NAME);
        StationRepository.printStations();
    }
}
