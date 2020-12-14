package subway.view.input;

import subway.view.component.LineManagementViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

public class LineManagementInputView {
    public static String getLineNameInput() {
        OutputViewComponent.printLog(LineManagementViewComponent.getLineRegisterBegin());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStartStationNameInput() {
        OutputViewComponent.printLog(LineManagementViewComponent.getStationRegisterStart());
        String startStationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return startStationName;
    }

    public static String getEndStationNameInput() {
        OutputViewComponent.printLog(LineManagementViewComponent.getStationRegisterEnd());
        String endStationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return endStationName;
    }

    public static String getLineNameInputRemove() {
        OutputViewComponent.printLog(LineManagementViewComponent.getLineRemoveBegin());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }
}
