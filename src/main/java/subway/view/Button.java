package subway.view;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/10
 */
public class Button {
    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String END = "Q";
    public static final String BACK = "B";

    private static final List<String> mainButtons = Arrays.asList(ONE, TWO, THREE, FOUR, END);
    private static final List<String> stationButtons = Arrays.asList(ONE, TWO, THREE, BACK);
    private static final List<String> lineButtons = Arrays.asList(ONE, TWO, THREE, BACK);
    private static final List<String> sectionButtons = Arrays.asList(ONE, TWO, BACK);

    private Button() {
    }

    public static boolean containsMainButton(String button) {
        return mainButtons.contains(button);
    }

    public static boolean containsStationButtons(String button) {
        return stationButtons.contains(button);
    }

    public static boolean containsLineButtons(String button) {
        return lineButtons.contains(button);
    }

    public static boolean containsSectionButtons(String button) {
        return sectionButtons.contains(button);
    }
}
