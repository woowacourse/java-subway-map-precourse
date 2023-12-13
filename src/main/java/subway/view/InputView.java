package subway.view;

import subway.domain.constants.FunctionCommand;
import subway.view.console.ConsoleReader;

public class InputView {
    private final ConsoleReader consoleReader;

    public InputView(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public FunctionCommand enterFunction() {
        return FunctionCommand.from(consoleReader.enterMessage());
    }
}
