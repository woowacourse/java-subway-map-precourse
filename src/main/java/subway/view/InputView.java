package subway.view;

import java.util.Scanner;
import subway.util.FeatureGroup;

public class InputView {
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.\n";
    private static final String INVALID_LENGTH = "[ERROR] 이름은 2글자 이상이어야 한다.\n";
    private static final int LENGTH = 2;

    private OutputView monitor;
    private Scanner scanner;

    public InputView(OutputView monitor, Scanner scanner) {
        this.monitor = monitor;
        this.scanner = scanner;
    }

    public String getScreenCommand(String screen, String message) {
        try {
            monitor.print(message);
            String command = scanner.nextLine();
            validateScreenCommand(screen, command);
            return command;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return getScreenCommand(screen, message);
        }
    }

    public String getStationName(String message) {
        try {
            monitor.print(message);
            String stationName = scanner.nextLine();
            validateLength(stationName);
            return stationName;
        } catch (Exception e) {
            monitor.print(e.getMessage());
            return getStationName(message);
        }
    }

    private void validateScreenCommand(String screen, String command) {
        FeatureGroup specificScreen = FeatureGroup.valueOf(screen);
        if (!specificScreen.hasFeature(command)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateLength(String stationName) {
        if (stationName.length() < LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }
}
