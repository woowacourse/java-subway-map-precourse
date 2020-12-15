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
    Scanner scanner;

    @Override
    public void mappingCommandToValidFunction(int command, Scanner scanner) {
        this.scanner = scanner;
        if (command == Action.INSERT.getActionNumber()) {
            addPath(Action.INSERT.getAction());
            return;
        }
        if (command == Action.DELETE.getActionNumber()) {
            return;
        }
    }

    public void addPath(String action){
        OutputView.printInputLine();
        String findLine = InputView.getCommand(scanner);
        OutputView.printInputStation();
        String inputStation = InputView.getCommand(scanner);
        OutputView.printInputOrder();
        int inputOrder = Integer.parseInt(InputView.getCommand(scanner)); //숫자가 아닌 경우 에러 처리 해야함.
        if(!LineRepository.addPathInLine(findLine, inputStation, inputOrder)){
            OutputView.printErrorAboutAddPath();
            return;
        }
        OutputView.printAlertAboutPath(action);
    }
}
