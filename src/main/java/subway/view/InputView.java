package subway.view;

import subway.domain.command.Command;
import subway.domain.command.MainCommand;

import java.util.Scanner;

public class InputView {
    private static final String SELECTION_GUIDE_MESSAGE = "## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Command inputMainCommand() {
        printSectionGuideMessage();
        String userMessage = inputWithTrimming();
        return Command.getCommand(MainCommand.values(), userMessage);
    }

    private void printSectionGuideMessage() {
        println(SELECTION_GUIDE_MESSAGE);
    }

    private String inputWithTrimming() {
        String inputValue = scanner.nextLine();
        return inputValue.trim();
    }

    private void println(String message) {
        System.out.println(message);
    }
}
