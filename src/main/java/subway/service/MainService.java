package subway.service;

import subway.domain.LineRepository;
import subway.view.OutputView;

public class MainService {
    public static void printEntireSubwayLine() {
        OutputView.printEntireSubwayLine(LineRepository.lines());
    }
}
