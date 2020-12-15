package subway.view.output.station;

import subway.type.TextType;

/**
 * StationTextView.java : 지하철 역 화면 출력 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationTextView {
    public static void printStationAdditionText() {
        System.out.println();
        System.out.println(TextType.STATION_ADDITION_TEXT.getText());
    }

    public static void printStationDeletionText() {
        System.out.println();
        System.out.println(TextType.STATION_DELETION_TEXT.getText());
    }
}
