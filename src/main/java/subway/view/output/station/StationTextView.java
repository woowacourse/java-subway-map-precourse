package subway.view.output.station;

import subway.type.TextType;

public class StationTextView {
    public static void printStationAddingText() {
        System.out.println();
        System.out.println(TextType.STATION_ADDING_TEXT.getText());
    }

    public static void printStationDeletionText() {
        System.out.println();
        System.out.println(TextType.STATION_DELETION_TEXT.getText());
    }
}
