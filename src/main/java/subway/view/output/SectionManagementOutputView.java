package subway.view.output;

import subway.view.component.SectionManagementViewComponent;
import subway.view.component.common.OutputViewComponent;

public class SectionManagementOutputView {
    public static void printMenuLog() {
        OutputViewComponent.printLogWithWhiteSpace(SectionManagementViewComponent.getMenu());
    }

    public static void printSectionRegisterFinishLog() {
        OutputViewComponent.printLogWithWhiteSpace(SectionManagementViewComponent.getSectionRegisterFinish());
    }

    public static void printSectionRemoveFinishLog() {
        OutputViewComponent.printLogWithWhiteSpace(SectionManagementViewComponent.getSectionRemoveFinish());
    }
}
