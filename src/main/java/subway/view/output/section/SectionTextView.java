package subway.view.output.section;

import subway.type.TextType;

public class SectionTextView {
    public static void printSectionAddingLineText() {
        System.out.println();
        System.out.println(TextType.SECTION_ADDITION_LINE_TEXT.getText());
    }

    public static void printSectionAddingStationText() {
        System.out.println();
        System.out.println(TextType.SECTION_ADDITION_STATION_TEXT.getText());
    }

    public static void printSectionAddingOrderText() {
        System.out.println();
        System.out.println(TextType.SECTION_ADDITION_ORDER_TEXT.getText());
    }

    public static void printSectionDeletionLineText() {
        System.out.println();
        System.out.println(TextType.SECTION_DELETION_LINE_TEXT.getText());
    }

    public static void printSectionDeletionStationText() {
        System.out.println();
        System.out.println(TextType.SECTION_DELETION_STATION_TEXT.getText());
    }
}
