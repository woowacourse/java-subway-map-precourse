package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.menu.MainMenu;
import subway.menu.Menu;
import subway.view.OutputView;

import java.util.List;

public class MainController implements SubwayController {

    private static final Menu STATE = MainMenu.LINE;
    private static LineRepository lineRepository = new LineRepository();

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void findAll() {
        List<Line> lines = lineRepository.lines();
        OutputView.printMap(lines);
    }

    @Override
    public void findBy() {

    }
}
