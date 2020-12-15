package subway.view.output.line;

import subway.type.TextType;

/**
 * LineTextView.java : 지하철 노선 화면 출력 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineTextView {
    public static void printLineAdditionText() {
        System.out.println();
        System.out.println(TextType.LINE_ADDITION_TEXT.getText());
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
