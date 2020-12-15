package subway.controller.mode;

import subway.controller.enums.ActionType;
import subway.service.StationService;
import subway.view.inputview.StationManagementInputView;
import subway.view.outputview.StationManagementOutputView;

import java.util.Scanner;

public class StationManagementMode {
    private final StationManagementOutputView stationManagementOutputView;
    private final StationManagementInputView stationManagementView;
    private String actionType;
    private final StationService stationService;
    private boolean isCompleted;

    public StationManagementMode(Scanner scanner, StationManagementOutputView stationManagementOutputView) {
        this.stationManagementOutputView = stationManagementOutputView;
        this.stationManagementView = new StationManagementInputView(scanner);
        this.stationService = new StationService(this.stationManagementView, this.stationManagementOutputView);
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
        this.stationManagementView.showOptions();
    }

    private String getAction() {
        return this.stationService.getActionType();
    }

    private boolean doAction() {
        if (this.actionType.equals(ActionType.ADD.getAction())) {
            return this.stationService.add();
        }

        if (this.actionType.equals(ActionType.DELETE.getAction())) {
            return this.stationService.delete();
        }

        if (this.actionType.equals(ActionType.PRINT.getAction())) {
            return this.stationService.print();
        }

        return true;
    }
}
