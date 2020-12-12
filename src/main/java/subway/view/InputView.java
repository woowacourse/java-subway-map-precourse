package subway.view;

import java.util.Scanner;
import subway.util.FeatureGroup;

public class InputView {
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INVALID_LENGTH = "[ERROR] 이름은 2글자 이상이어야 한다.";
    private static final int LENGTH = 2;

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getScreenCommand(String screen) {
        try {
            String command = scanner.nextLine();
            validateScreenCommand(screen,command);
            return command;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getScreenCommand(screen);
        }
    }

    public String getStationName() {
        try {
            String stationName = scanner.nextLine();
            validateLength(stationName);
            return stationName;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getStationName();
        }
    }

    private void validateScreenCommand(String screen,String command) {
        FeatureGroup specificScreen = FeatureGroup.valueOf(screen);
        if(!specificScreen.hasFeature(command)){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateLength(String stationName) {
        if (stationName.length() < LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }
}
