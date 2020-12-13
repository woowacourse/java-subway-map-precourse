package subway.view.output.line;

import subway.type.TextType;

public class LineTextView {
    public static void printLineAddingText() {
        System.out.println();
        System.out.println(TextType.LINE_ADDING_TEXT.getText());
    }

    public static void printLineUpStationNameText() {
        System.out.println();
        System.out.println(TextType.LINE_UP_STATION_NAME_TEXT.getText());
    }

    public static void printLineDownStationNameText() {
        System.out.println();
        System.out.println(TextType.LINE_DOWN_STATION_NAME_TEXT.getText());
    }

    public static void printLineDeletionText() {
        System.out.println();
        System.out.println(TextType.LINE_DELETION_TEXT.getText());
    }
}
