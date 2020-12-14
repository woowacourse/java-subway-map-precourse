package subway.view.output.section;

import subway.type.InformationType;

public class SectionInformationView {
    public static void printSectionAddingInformation() {
        System.out.println();
        System.out.println(InformationType.SECTION_ADDING_INFORMATION.getInformation());
    }

    public static void printSectionDeletionInformation() {
        System.out.println();
        System.out.println(InformationType.SECTION_DELETION_INFORMATION.getInformation());
    }
}
