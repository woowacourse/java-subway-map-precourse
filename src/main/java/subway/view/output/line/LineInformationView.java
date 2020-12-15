package subway.view.output.line;

import subway.type.InformationType;

/**
 * LineInformationView.java : 지하철 노선 실행 결과 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineInformationView {
    public static void printLineAdditionInformation() {
        System.out.println();
        System.out.println(InformationType.LINE_ADDITION_INFORMATION.getInformation());
    }

    public static void printLineDeletionInformation() {
        System.out.println();
        System.out.println(InformationType.LINE_DELETION_INFORMATION.getInformation());
    }
}
