package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Action;

import java.security.spec.NamedParameterSpec;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LineController implements Controller {
    private static final String NAME = "노선";
    private static final String UP = "상";
    private static final String DOWN = "하";
    private static final int MIN_NAME_LENGTH = 2;
    private static String lineName;
    private static Station upStation;
    private static Station downStation;
    Scanner scanner;

    @Override
    public void mappingCommandToValidFunction(int command, Scanner scanner) {
        this.scanner = scanner;
        if (command == Action.INSERT.getActionNumber()) {
            inputLineFromUser(Action.INSERT.getAction());
            addLine(Action.INSERT.getAction());
            return;
        }
        if (command == Action.DELETE.getActionNumber()) {
            deleteLine(Action.DELETE.getAction());
            return;
        }
        if (command == Action.SELECT.getActionNumber()) {
            selectLine();
            return;
        }
    }

    public void addLine(String action) {
        if (!isLineNameMoreThanTwoLetters() || !isLineAlreadyExist()) {
            return;
        }
        if (isSameNameBetweenUpStationAndDownStation()) {
            return;
        }
        List<Station> stations = Arrays.asList(upStation, downStation);
        if (isStationAlreadyExist(stations)) {
            return;
        }
        Line line = new Line(lineName, upStation, downStation);
        LineRepository.addLine(line);
        OutputView.printAlert(action, NAME);
        OutputView.printNewLine();
    }

    public void inputLineFromUser(String action) {
        OutputView.printWithAction(action, NAME);
        lineName = InputView.getCommand(scanner);
        OutputView.printUpAndDownLineMessage(UP);
        upStation = new Station(InputView.getCommand(scanner));
        OutputView.printUpAndDownLineMessage(DOWN);
        downStation = new Station(InputView.getCommand(scanner));
    }

    public boolean isSameNameBetweenUpStationAndDownStation() {
        if(upStation.getName().equals(downStation.getName())){
            OutputView.printSameNameErrorMessage();
            return true;
        }
        return false;
    }

    public boolean isLineNameMoreThanTwoLetters() {
        if(lineName.length() < MIN_NAME_LENGTH){
            OutputView.printNameLengthErrorMessage(NAME, lineName);
            return false;
        }
        return true;
    }

    public boolean isStationAlreadyExist(List<Station> stations) {
        for (Station station : stations) {
            if (StationRepository.hasDuplicatedStation(station)) {
                OutputView.printStationDoesNotExistErrorMessage(station.getName());
                return true;
            }
        }
        return false;
    }

    public boolean isLineAlreadyExist(){
        if(LineRepository.hasDuplicatedLine(lineName)){
            OutputView.printDuplicatedErrorMessage(lineName);
            return false;
        }
        return true;
    }

    public void deleteLine(String action) {
        OutputView.printWithAction(action, NAME);
        String line = InputView.getCommand(scanner);
        if (LineRepository.deleteLineByName(line)) {
            OutputView.printAlert(action, NAME);
            return;
        }
        OutputView.printDoesNotExistErrorMessage(line);
    }

    public void selectLine() {
        OutputView.printList(NAME);
        LineRepository.printOnlyLineName();
    }
}
