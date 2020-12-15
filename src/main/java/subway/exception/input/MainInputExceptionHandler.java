package subway.exception.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.controller.MainController;

public class MainInputExceptionHandler extends InputExceptionHandler {

    private static final List<String> MAIN_PATTERN = new ArrayList<>(
        Arrays.asList("1", "2", "3", "4", "Q"));

    public static void unselectable(String input) {
        if (contains(input, MAIN_PATTERN)) {
            return;
        }
        unselectableError();
        MainController.select();
    }
}
