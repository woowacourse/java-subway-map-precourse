package subway;

import subway.line.domain.LineRepository;
import subway.view.OutputView;

public class SubwayMapPrinter {
    public static void print() {
        OutputView.printSubwayMap(LineRepository.findAll());
    }
}
