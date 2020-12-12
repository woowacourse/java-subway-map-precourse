package subway.service;

import subway.domain.LineRepository;
import subway.option.MainOption;
import subway.view.OutputView;

import java.util.Arrays;

public class MainService extends BaseService {
    public static void main () {
        view(Arrays.asList(MainOption.values()), MainOption.HEADER);
    }
    public static void printEntireSubwayLine() {
        OutputView.printEntireSubwayLine(LineRepository.lines());
    }
}
