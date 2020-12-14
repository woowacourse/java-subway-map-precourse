package subway.view.output;

import subway.domain.Station;
import subway.view.component.CommonViewComponent;
import subway.view.component.LineManagementViewComponent;
import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.OutputViewComponent;

import java.util.List;

public class StationManagementOutputView {
    public static void printMenuLog(){
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getMenuComponent());
    }

    public static void printStationRegisterFinishLog() {
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getRegisterStationFinishComponent());
    }

    public static void printStationRemoveFinishLog(){
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getRemoveStationFinishComponent());
    }

    public static void printStationList(List<Station> stationList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Station station : stationList){
            stringBuilder.append(StationManagementViewComponent.getFinishPrefixComponent());
            stringBuilder.append(station.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLineComponent());
        }
        System.out.println(stringBuilder.toString());
    }
}
