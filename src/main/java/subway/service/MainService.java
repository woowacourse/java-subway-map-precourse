package subway.service;

import subway.domain.LineRepository;
import subway.question.MainQuestion;
import subway.view.OutputView;

import java.util.Arrays;

public class MainService extends BaseService {
    public static void main () {
        view(Arrays.asList(MainQuestion.values()), MainQuestion.HEADER);
    }
    public static void printEntireSubwayLine() {
        OutputView.printEntireSubwayLine(LineRepository.lines());
    }
}
