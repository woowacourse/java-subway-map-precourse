package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Path;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Action;

import java.util.Scanner;

public class PathController implements Controller {
    private static final String NAME = "구간";
    public static final String DIGIT_REGEX = "^[0-9]*$";
    public static String line;
    public static String station;
    public static String order;
    Scanner scanner;

    @Override
    public void mappingCommandToValidFunction(int command, Scanner scanner) {
        this.scanner = scanner;
        if (command == Action.INSERT.getActionNumber()) {
            inputFromUser();
            addPath(Action.INSERT.getAction());
            return;
        }
        if (command == Action.DELETE.getActionNumber()) {
            deletePath(Action.DELETE.getAction());
            return;
        }
    }

    public void addPath(String action) {
        if (!isDigit(order)) {
            OutputView.printErrorAboutNotValidIndex();
            return;
        }
        if (!LineRepository.addPathInLine(line, station, Integer.parseInt(order))) {
            OutputView.printErrorAboutPath(action);
            return;
        }
        OutputView.printAlertAboutPath(action);
    }

    public void inputFromUser() {
        OutputView.printInputLine();
        line = InputView.getCommand(scanner);
        OutputView.printInputStation();
        station = InputView.getCommand(scanner);
        OutputView.printInputOrder();
        order = InputView.getCommand(scanner);
    }

    public boolean isDigit(String digit) {
        return digit.matches(DIGIT_REGEX);
    }

    public void deletePath(String action) {
        OutputView.printDeleteLineInPath();
        line = InputView.getCommand(scanner);
        OutputView.printDeleteStationInPath();
        station = InputView.getCommand(scanner);
        if (!LineRepository.deletePathInLine(line, station)) {
            OutputView.printErrorAboutPath(action);
            return;
        }
        OutputView.printAlertAboutPath(action);
    }
}
