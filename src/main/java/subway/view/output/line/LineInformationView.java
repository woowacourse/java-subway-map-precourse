package subway.view.output.line;

import subway.type.InformationType;

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
