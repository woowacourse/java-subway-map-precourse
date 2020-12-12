package subway.view;

import java.util.Scanner;

public class InputView {
    private static final String STATION = "1";
    private static final String LINE = "2";
    private static final String SECTION = "3";
    private static final String QUIT = "Q";
    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String SEARCH = "3";
    private static final String BACK = "B";
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INVALID_LENGTH = "[ERROR] 이름은 2글자 이상이어야 한다.";
    private static final int LENGTH = 2;

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

    public String getStationManagementScreenCommand() {
        OutputView.printStationManagementScreen();
        try {
            String command = scanner.nextLine();
            validateStationManagementScreenCommand(command);
            return command;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getStationManagementScreenCommand();
        }
    }

    public String getStationNameToRegister() {
        OutputView.printOrderToRegisterStation();
        try {
            String stationName = scanner.nextLine();
            validateLength(stationName);
            return stationName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getStationNameToRegister();
        }
    }

    public String getStationNameToDelete() {
        OutputView.printOrderToDeleteStation();
        try {
            String stationName = scanner.nextLine();
            validateLength(stationName);
            return stationName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getStationNameToDelete();
        }
    }

    private void validateMainScreenCommand(String command) {
        if (!command.equals(STATION) && !command.equals(LINE) &&
            !command.equals(SECTION) && !command.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateStationManagementScreenCommand(String command) {
        if (!command.equals(REGISTER) && !command.equals(DELETE) &&
            !command.equals(SEARCH) && !command.equals(BACK)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateLength(String stationName) {
        if (stationName.length() < LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }


}
