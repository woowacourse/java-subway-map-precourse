package subway.view.output.section;

import subway.type.InformationType;

/**
 * SectionInformationView.java : 지하철 구간 실행 결과 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionInformationView {
    public static void printSectionAdditionInformation() {
        System.out.println();
        System.out.println(InformationType.SECTION_ADDITION_INFORMATION.getInformation());
    }

    public static void printSectionDeletionInformation() {
        System.out.println();
        System.out.println(InformationType.SECTION_DELETION_INFORMATION.getInformation());
    }
}
