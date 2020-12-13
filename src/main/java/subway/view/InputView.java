package subway.view;

import java.util.Scanner;
import subway.utils.Message;
import subway.utils.Validator;

public class InputView implements Message {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TITLE = "## ";


    public static String getSelection() {
        printTitle(INPUT_SELECTION);
        return getInput();
    }

    public static String getStationName() {
        printTitle(INPUT_GET_STATION);
        String name = getInput();
        Validator.checkValidStationName(name);
        return name;
    }

    public static String getStationNameToDelete() {
        printTitle(INPUT_DELETE_STATION);
        return getInput();
    }

    public static String getLineName() {
        printTitle(INPUT_GET_LINE);
        String name = getInput();
        Validator.checkValidLineName(name);
        return name;
    }

    public static String getFirstStationName() {
        printTitle(INPUT_GET_FIRST_STATION);
        return getInput();
    }

    public static String getLastStationName() {
        printTitle(INPUT_GET_LAST_STATION);
        return getInput();
    }

    public static String getLineNameToDelete() {
        printTitle(INPUT_DELETE_LINE);
        return getInput();
    }

    public static String getLineNameInSection() {
        printTitle(INPUT_GET_LINE_IN_SECTION);
        return getInput();
    }

    public static String getStationNameInSection() {
        printTitle(INPUT_GET_STATION_IN_SECTION);
        return getInput();
    }

    public static String getOrderInSection() {
        printTitle(INPUT_GET_ORDER);
        return getInput();
    }

    public static String getLineNameToDeleteInSection() {
        printTitle(INPUT_DELETE_LINE_IN_SECTION);
        return getInput();
    }

    public static String getStationNameToDeleteInSection() {
        printTitle(INPUT_DELETE_STATION_IN_SECTION);
        return getInput();
    }

    public static String getInput() {
        String input = scanner.nextLine().trim();
        breakLine();
        return input;
    }

    private static void breakLine() {
        System.out.println();
    }

    private static void printTitle(String message) {
        System.out.println(TITLE + message);
    }

}
