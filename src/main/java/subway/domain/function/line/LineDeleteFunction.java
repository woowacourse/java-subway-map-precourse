package subway.domain.function.line;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class LineDeleteFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String lineName = InputView.inputLineToDelete(scanner);
        LineRepository.deleteLineByName(lineName);
        OutputView.printSuccessToDeleteLine();
    }
}
