package subway.domain.function.line;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.OutputView;

public class LineReadFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        OutputView.printLine(LineRepository.lines());
    }
}
