package subway.service;

import subway.domain.LineRepository;
import subway.option.MainOption;
import subway.view.OutputView;

import java.util.Arrays;

public class MainService extends BaseService {
    private static final String HEADER = "## 메인 화면";

    public static void view() {
        getUserChoiceWithinOptionList(Arrays.asList(MainOption.values()), HEADER);
    }
    public static void printEntireSubwayLine() {
        OutputView.printEntireSubwayLine(LineRepository.lines());
    }
}
