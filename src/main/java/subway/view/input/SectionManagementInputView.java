package subway.view.input;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.component.SectionManagementViewComponent;
import subway.view.component.common.InputViewComponent;
import subway.view.component.common.OutputViewComponent;

import java.util.Scanner;

public class SectionManagementInputView {
    public static String getLineNameAddInput() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterLineNameInputComponent());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStationNameAddInput() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterStationNameInputComponent());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }

    public static int getStationPosition() {
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRegisterStationOrderComponent());
        int position = Integer.parseInt(InputViewComponent.getInput());
        OutputViewComponent.printWhiteSpace();
        return position;
    }

    public static String getLineNameRemoveInput(){
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRemoveLineNameInputComponent());
        String lineName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return lineName;
    }

    public static String getStationNameRemoveInput(){
        OutputViewComponent.printLog(SectionManagementViewComponent.getSectionRemoveStationNameInputComponent());
        String stationName = InputViewComponent.getInput();
        OutputViewComponent.printWhiteSpace();
        return stationName;
    }
}
