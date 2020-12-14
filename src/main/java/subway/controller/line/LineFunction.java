package subway.controller.line;

import subway.domain.LineRepository;
import subway.view.InputView;

public class LineFunction {
    public static LineRepository add(LineRepository lineRepository) {
        String line = InputView.input();

        return lineRepository;
    }

    public static LineRepository delete(LineRepository lineRepository) {
        return null;
    }

    public static LineRepository printAll(LineRepository lineRepository) {
        return null;
    }
}
