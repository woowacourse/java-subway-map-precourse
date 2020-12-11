package subway.console;

import java.util.Arrays;
import java.util.List;

public class ConsoleValidator implements SectionScreen, StationScreen, LineScreen, MainScreen {
    public static String ERROR_MAIN_SCREEN_NOT_VALID_INPUT = "[ERROR] 잘못된 기능 입력입니다.";

    public static void validateMainInput(String mainInput) {
        List<String> choices = Arrays.asList(MAIN_MENU_CHOICES);
        if(!choices.contains(mainInput)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
    }

}
