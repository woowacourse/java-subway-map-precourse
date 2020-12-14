package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.LineMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class LineController implements SubwayController {

    private final LineRepository lineRepository = new LineRepository();
    private final StationRepository stationRepository = new StationRepository();
    private final InputView inputView = InputView.getInstance();

    private static final String INPUT_START_MESSAGE = "## 등록할 노선의 상행 종점을 입력하세요.";
    private static final String INPUT_END_MESSAGE = "## 등록할 노선의 하행 종점을 입력하세요.";

    @Override
    public void save() {

        OutputView.printInputMessage(LineMenu.REGISTER);

        String lineName = inputView.input();
        Station station1 = inputStartStation();
        Station station2 = inputLastStation();

        Line line = Line.of(lineName, station1, station2);
        lineRepository.addLine(line);

        OutputView.printResultMessage(LineMenu.REGISTER);
    }

    private Station inputLastStation() {
        System.out.println(INPUT_END_MESSAGE);
        Station station2 = selectStation();
        return station2;
    }

    private Station inputStartStation() {
        System.out.println(INPUT_START_MESSAGE);
        return selectStation();
    }

    private Station selectStation() {
        String stationName1 = inputView.input();
        return stationRepository.findBy(stationName1);
    }

    @Override
    public void delete() {
        OutputView.printInputMessage(LineMenu.DELETE);

        String name = inputView.input();
        lineRepository.deleteLineByName(name);

        OutputView.printResultMessage(LineMenu.DELETE);
    }

    @Override
    public void findAll() {
        OutputView.printListTitle(LineMenu.SEARCH);

        List<Line> lines = lineRepository.lines();

        OutputView.printLines(lines);
    }

    @Override
    public void findBy() {

    }
}
