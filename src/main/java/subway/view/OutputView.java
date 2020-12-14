package subway.view;

import subway.exception.SubwayException;

public class OutputView {

    public static void printInformation(final String information) {
        System.out.println();
        System.out.println(TextCollection.INFO_TAG + information);
    }

    public static void printErrorMessage(SubwayException exception) {
        System.out.println(exception.getMessage());
        System.out.println();
    }

}
