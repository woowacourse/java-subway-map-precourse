package subway.view.output.section;

import subway.type.TextType;

/**
 * SectionTextView.java : 지하철 구간 화면 출력 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionTextView {
    public static void printSectionAdditionLineText() {
        System.out.println();
        System.out.println(TextType.SECTION_ADDITION_LINE_TEXT.getText());
    }

    public static void printSectionAdditionStationText() {
        System.out.println();
        System.out.println(TextType.SECTION_ADDITION_STATION_TEXT.getText());
    }

    public static void printSectionAdditionOrderText() {
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
