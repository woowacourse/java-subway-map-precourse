package subway.view.output.line;

import subway.type.InformationType;

public class LineInformationView {
    public static void printLineAddingInformation() {
        System.out.println();
        System.out.println(InformationType.LINE_ADDING_INFORMATION.getInformation());
    }
}
