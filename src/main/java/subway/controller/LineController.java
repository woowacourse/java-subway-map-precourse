package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.screen.Action;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LineController implements Controller {
    private static final String NAME = "노선";
    private static final String UP = "상";
    private static final String DOWN = "하";
    Scanner scanner;

    @Override
    public void mappingCommandToValidFunction(int command, Scanner scanner) {
        this.scanner = scanner;
        if (command == Action.INSERT.getActionNumber()) {
            addLine(Action.INSERT.getAction());
            return;
        }
        if (command == Action.DELETE.getActionNumber()) {
            deleteLine(Action.DELETE.getAction());
            return;
        }
        if (command == Action.SELECT.getActionNumber()) {
            selectLine(Action.SELECT.getAction());
            return;
        }
    }

    // 함수 분리하기
    public void addLine(String action) {
        OutputView.printWithAction(action, NAME);
        String lineName = InputView.getCommand(scanner);
        OutputView.printUpAndDownLineMessage(UP);
        Station upStation = new Station(InputView.getCommand(scanner));
        OutputView.printUpAndDownLineMessage(DOWN);
        Station downStation = new Station(InputView.getCommand(scanner));

        // upstation과 downstation이 다른지 확인해야함.
        // station 생성자 생성 시 중복 확인하는 코드 넣어야함.
        // line명 두글자 이상인지 확인해야함.
        // line명 중복 있는지 확인해야함.

        List<Station> stations = Arrays.asList(upStation, downStation);
        StationRepository.addStations(stations);
        Line line =  new Line(lineName, upStation, downStation);
        LineRepository.addLine(line);
    }

    public void deleteLine(String action) {

    }

    public void selectLine(String action) {

    }
}
