package subway.controller;

import subway.domain.Line.Line;
import subway.domain.Line.LineRepository;
import subway.view.OutputView;

import java.util.List;

public class MainController implements SubwayController {

    private static LineRepository lineRepository = new LineRepository();

    @Override
    public void save() {
        // 미구현
    }

    @Override
    public void delete() {
        // 미구현
    }

    @Override
    public void findAll() {
        List<Line> lines = lineRepository.lines();
        OutputView.printMap(lines);
    }

    @Override
    public void findBy() {
        // 미구현
    }
}
