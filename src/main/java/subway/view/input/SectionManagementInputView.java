package subway.view.input;

import subway.view.component.SectionManagementViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

public class SectionManagementInputView {
    public static String getLineNameAddInput() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterLineNameInput());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStationNameAddInput() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterStationNameInput());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }

    public static int getStationPosition() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterStationOrder());
        int position = Integer.parseInt(InputViewComponent.getInput());
        OutputViewComponent.printWhiteSpace();
        return position;
    }

    public static String getLineNameRemoveInput(){
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRemoveLineNameInput());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStationNameRemoveInput(){
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRemoveStationNameInput());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }
}
