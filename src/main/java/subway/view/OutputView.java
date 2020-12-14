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

    public static void printStation(String station) {
        System.out.println(TextCollection.INFO_TAG + station);
    }

    public static void printErrorMessage(SubwayException exception) {
        System.out.println(exception.getMessage());
        System.out.println();
    }

}
