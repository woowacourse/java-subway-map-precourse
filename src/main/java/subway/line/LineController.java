package subway.line;

import subway.line.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.view.resource.Strings.*;

public class LineController {
    private LineController() {
    }

    public static void execute() {
        OutputView.printGuide(SELECT_LINE_FUNCTION);
        String command = InputView.getFunction();
        Runnable function = LineFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String name = InputView.getLineNameForRegistration();
        String topStation = InputView.getTopStation();
        String bottomStation = InputView.getBottomStation();
        LineService.register(name, topStation, bottomStation);
        OutputView.printlnResult(COMPLETE_LINE_REGISTRATION);
    }

    public static void remove() {
        String name = InputView.getLineNameForRemoval();
        LineService.remove(name);
        OutputView.printlnResult(COMPLETE_LINE_REMOVAL);
    }

    public static void inquire() {
        OutputView.printLines(LineRepository.findAll());
    }
}
