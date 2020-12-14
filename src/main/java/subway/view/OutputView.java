package subway.view;

import subway.exception.SubwayException;

public class OutputView {

    public static void printQuestion(String message) {
        System.out.println();
        System.out.printf("%s %s\n", TextCollection.PREFIX, message);
    }

    public static void printInformation(String information) {
        System.out.println();
        System.out.println(TextCollection.INFO_TAG + information);
    }

    public static void printStationOrLine(String name) {
        System.out.println(TextCollection.INFO_TAG + name);
    }

    public static void printErrorMessage(SubwayException exception) {
        System.out.println();
        System.out.println(exception.getMessage());
    }

}
