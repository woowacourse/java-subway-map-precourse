package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String STATION = "1";
    private static final String LINE = "2";
    private static final String SECTION = "3";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String QUIT = "Q";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainScreenCommand() {
        OutputView.printMainScreen();
        try {
            String command = scanner.nextLine();
            validateMainScreenCommand(command);
            return command;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getMainScreenCommand();
        }
    }

    private void validateMainScreenCommand(String command) {
        if (!command.equals(STATION) && !command.equals(LINE) &&
            !command.equals(SECTION) && !command.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }


}
