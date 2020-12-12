package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.menu.LineMenu;
import subway.menu.Menu;
import subway.view.InputView;

import java.util.List;

public class LineController implements SubwayController {

    private static final Menu STATE = LineMenu.BACK;
    private final LineRepository lineRepository = new LineRepository();
    private final StationRepository stationRepository = new StationRepository();
    private final InputView inputView = InputView.getInstance();

    private static final String INPUT_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String INPUT_START_MESSAGE = "## 등록할 노선의 상행 종점을 입력하세요.";
    private static final String INPUT_END_MESSAGE = "## 등록할 노선의 하행 종점을 입력하세요.";

    @Override
    public void save() {

        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputView.input();


        System.out.println(INPUT_START_MESSAGE);
        Station station1 = selectStation();

        System.out.println(INPUT_END_MESSAGE);
        Station station2 = selectStation();

        Line line = Line.of(lineName, station1, station2);

        lineRepository.addLine(line);
    }

    private Station selectStation() {
        String stationName1 = inputView.input();
        return stationRepository.findBy(stationName1);
    }

    @Override
    public void delete() {
        String name = inputView.input();
        lineRepository.deleteLineByName(name);
    }

    @Override
    public void findAll() {

    }

    @Override
    public void findBy() {

    }
}
