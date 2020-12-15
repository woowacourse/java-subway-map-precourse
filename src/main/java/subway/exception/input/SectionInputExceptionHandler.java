package subway.exception.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.Controller.SectionController;

public class SectionInputExceptionHandler extends InputExceptionHandler {

    private static final List<String> SECTION_PATTERN = new ArrayList<>(
        Arrays.asList("1", "2", "B"));

    public static void unselectable(String input) {
        if (contains(input, SECTION_PATTERN)) {
            return;
        }
        unselectableError();
        SectionController.select();
    }
}
