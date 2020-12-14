package subway.controller.mode;

import subway.controller.enums.ActionType;
import subway.service.SectionService;
import subway.view.inputview.SectionManagementInputView;
import subway.view.outputview.SectionManagementOutputView;

import java.util.Scanner;

public class SectionManagementMode {
    private final SectionManagementOutputView sectionManagementOutputView;
    private final SectionManagementInputView sectionManagementInputView;
    private String actionType;
    private final SectionService sectionService;
    private boolean isCompleted;

    public SectionManagementMode(Scanner scanner, SectionManagementOutputView sectionManagementOutputView) {
        this.sectionManagementOutputView = sectionManagementOutputView;
        this.sectionManagementInputView = new SectionManagementInputView(scanner);
        this.sectionService = new SectionService(this.sectionManagementInputView, this.sectionManagementOutputView);
    }

    public void run() {
        this.isCompleted = false;

        while (!this.isCompleted) {
            showMenu();
            this.actionType = getAction();
            this.isCompleted = doAction();
        }
    }

    private void showMenu() {
        this.sectionManagementInputView.showOptions();
    }

    private String getAction() {
        return this.sectionService.getActionType();
    }

    private boolean doAction() {
        if (this.actionType.equals(ActionType.ADD.getAction())) {
            return this.sectionService.add();
        }

        if (this.actionType.equals(ActionType.DELETE.getAction())) {
            return this.sectionService.delete();
        }

        return true;
    }
}
