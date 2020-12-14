package subway.function.section.type;

import java.util.Scanner;
import subway.function.section.management.DeleteSection;
import subway.function.section.management.RegisterNewSection;
import subway.main.type.UserSelections;

public class SectionManagementTypeResolver {
    public static SectionManagementType getSectionManagementType(String userInput) {
        if (userInput.equals(UserSelections.FIRST)) {
            return SectionManagementType.SECTION_REGISTRATION;
        }
        if (userInput.equals(UserSelections.SECOND)) {
            return SectionManagementType.DELETE_SECTION;
        }
        return SectionManagementType.GO_BACK;
    }

    public static void resolveSectionManagement(SectionManagementType type, Scanner scanner)
        throws IllegalArgumentException {
        if (type == SectionManagementType.SECTION_REGISTRATION) {
            RegisterNewSection.registerNewSection(scanner);
        }
        if (type == SectionManagementType.DELETE_SECTION) {
            DeleteSection.deleteSection(scanner);
        }
    }
}
