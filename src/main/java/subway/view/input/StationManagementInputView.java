package subway.view.input;

import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

public class StationManagementInputView {
    public static String getStationNameRegisterInput() {
        OutputViewComponent.printLog(StationManagementViewComponent.getRegisterStationComponent());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }

    public static String getStationNameRemoveInput(){
        OutputViewComponent.printLog(StationManagementViewComponent.getRemoveStationComponent());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }
}
