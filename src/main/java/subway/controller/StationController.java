package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Action;

import java.util.Scanner;

public class StationController implements Controller {
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
            selectStation(Action.SELECT.getAction());
            return;
        }
    }

    private void addStation(String action) {
        OutputView.printWithAction(action);
        String station = InputView.getCommand(scanner);
        if (StationRepository.addStation(new Station(station))) {
            OutputView.printAlert(action);
            return;
        }
        OutputView.printDuplicatedErrorMessage(station.toString());
    }

    private void deleteStation(String action) {
        OutputView.printWithAction(action);
        String station = InputView.getCommand(scanner);
        if (StationRepository.deleteStation(station)) {
            OutputView.printAlert(action);
            return;
        }
        OutputView.printStationDeleteErrorMessage();
    }

    private void selectStation(String action) {
        // 역 조회 기능 구현
    }
}
