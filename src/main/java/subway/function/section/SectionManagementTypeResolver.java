package subway.function.section;

import java.util.Scanner;
import subway.main.UserSelections;

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

    public static void resolveSectionManagement(SectionManagementType type, Scanner scanner) {
        try {
            if (type == SectionManagementType.SECTION_REGISTRATION) {
                SectionManagement.registerNewSection(scanner);
            }
            if (type == SectionManagementType.DELETE_SECTION) {
                SectionManagement.deleteSection(scanner);
            }
        } catch (IllegalArgumentException ignored) {
        }
    }
}
