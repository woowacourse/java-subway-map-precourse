package subway.controller.mode;

import subway.controller.enums.ActionType;
import subway.service.LineService;
import subway.view.inputview.LineManagementInputView;
import subway.view.outputview.LineManagementOutputView;

import java.util.Scanner;

public class LineManagementMode {
    private final LineManagementOutputView lineManagementOutputView;
    private final LineManagementInputView lineManagementInputView;
    private String actionType;
    private final LineService lineService;
    private boolean isCompleted;

    public LineManagementMode(Scanner scanner, LineManagementOutputView lineManagementOutputView) {
        this.lineManagementOutputView = lineManagementOutputView;
        this.lineManagementInputView = new LineManagementInputView(scanner);
        this.lineService = new LineService(this.lineManagementInputView, this.lineManagementOutputView);
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
        this.lineManagementInputView.showOptions();
    }

    private String getAction() {
        return this.lineService.getActionType();
    }

    private boolean doAction() {
        if (this.actionType.equals(ActionType.ADD.getAction())) {
            return this.lineService.add();
        }

        if (this.actionType.equals(ActionType.DELETE.getAction())) {
            return this.lineService.delete();
        }

        if (this.actionType.equals(ActionType.PRINT.getAction())) {
            return this.lineService.print();
        }

        return true;
    }
}
