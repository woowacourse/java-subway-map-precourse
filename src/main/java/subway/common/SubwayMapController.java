package subway.common;

import subway.line.domain.LineRepository;
import subway.view.OutputView;

public class SubwayMapController {
    private SubwayMapController() {
    }

    public static void print() {
        OutputView.printSubwayMap(LineRepository.findAll());
    }
}
