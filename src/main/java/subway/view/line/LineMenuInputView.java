package subway.view.line;

import java.util.Scanner;

public class LineMenuInputView {

    private static final String LINE_ENROLL_MENU = "1";
    private static final String LINE_DELETE_MENU = "2";
    private static final String LINE_PRINTALL_MENU = "3";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String BACK_MENU = "B";

    public static String getLineMenuCommand(Scanner scanner) {
        LineMenuOutputView.printLineMenu();
        try {
            String lineMenuCommand = scanner.nextLine();
            validateLineMenuCommand(lineMenuCommand);
            return lineMenuCommand;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLineMenuCommand(scanner);
        }
    }

    private static void validateLineMenuCommand(String lineMenuCommand) {
        if (!lineMenuCommand.equals(LINE_ENROLL_MENU) && !lineMenuCommand.equals(LINE_DELETE_MENU) &&
                !lineMenuCommand.equals(LINE_PRINTALL_MENU) && !lineMenuCommand.equals(BACK_MENU)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
