package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.List;

public class LineController implements Controller {
    private static LineRepository lineRepository = new LineRepository();

    @Override
    public void start() {
        System.out.println("line 시작");
    }

    public static List<Line> informAllLines() {
        return lineRepository.lines();
    }
}
