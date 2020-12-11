package subway.service;

import subway.type.InputType;

public class SectionService {
    public static boolean isSectionInput(String sectionInput) {
        if (sectionInput.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (sectionInput.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        return sectionInput.equals(InputType.INPUT_BACK.getInput());
    }
}
