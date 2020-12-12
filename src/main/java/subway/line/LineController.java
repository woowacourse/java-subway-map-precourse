package subway.line;

import subway.line.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {
    private LineController() {
    }

    public static void execute() {
        String command = InputView.getFunction();
        Runnable function = LineFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String name = InputView.getLineNameForRegistration();
        String topStation = InputView.getTopStation();
        String bottomStation = InputView.getBottomStation();
        LineService.register(name, topStation, bottomStation);
    }

    public static void remove() {
        String name = InputView.getLineNameForRemoval();
        LineService.remove(name);
    }

    public static void inquire() {
        OutputView.printLines(LineRepository.findAll());
    }
}
