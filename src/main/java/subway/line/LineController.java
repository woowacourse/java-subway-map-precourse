package subway.line;

import subway.line.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.resource.LineMessage;

public class LineController {
    private LineController() {
    }

    public static void execute() {
        OutputView.printGuide(LineMessage.SELECT_FUNCTION);
        String command = InputView.getFunction();
        Runnable function = LineFunctionMapper.matchFunction(command);
        function.run();
    }

    public static void register() {
        String name = InputView.getLineNameForRegistration();
        String topStation = InputView.getTopStation();
        String bottomStation = InputView.getBottomStation();
        LineService.register(name, topStation, bottomStation);
        OutputView.printlnResult(LineMessage.COMPLETE_REGISTRATION);
    }

    public static void remove() {
        String name = InputView.getLineNameForRemoval();
        LineService.remove(name);
        OutputView.printlnResult(LineMessage.COMPLETE_REMOVAL);
    }

    public static void inquire() {
        OutputView.printLines(LineRepository.findAll());
    }
}
