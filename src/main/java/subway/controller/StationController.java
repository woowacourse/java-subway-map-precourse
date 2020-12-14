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
            deleteStation();
            return;
        }
        if (command == Action.SELECT.getActionNumber()) {
            selectStation();
            return;
        }
    }

    private void addStation(String action) {
        OutputView.printWithAction(action);
        String station = InputView.getCommand(scanner);
        if (StationRepository.addStation(new Station(station))) {
            OutputView.printWithInformationMark(action);
        }
    }

    private void deleteStation() {
        // 역 삭제 기능 구현
    }

    private void selectStation() {
        // 역 조회 기능 구현
    }
}
