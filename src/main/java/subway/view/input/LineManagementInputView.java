package subway.view.input;

import subway.view.component.LineManagementViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

public class LineManagementInputView {
    public static String getLineNameInput(){
        OutputViewComponent.printLog(LineManagementViewComponent.getLineRegisterComponent());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStartStationNameInput(){
        OutputViewComponent.printLog(LineManagementViewComponent.getStationRequiringBeginComponent());
        String startStationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return startStationName;
    }

    public static String getEndStationNameInput(){
        OutputViewComponent.printLog(LineManagementViewComponent.getStationRequiringEndComponent());
        String endStationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return endStationName;
    }

    public static String getLineNameInputRemove(){
        OutputViewComponent.printLog(LineManagementViewComponent.getRemoveLineBeginComponent());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }
}
