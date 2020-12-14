package subway.view.output;

import subway.domain.Station;
import subway.view.component.CommonViewComponent;
import subway.view.component.StationManagementViewComponent;
import subway.view.component.common.OutputViewComponent;

import java.util.List;

public class StationManagementOutputView {
    public static void printMenuLog() {
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getMenu());
    }

    public static void printStationRegisterFinishLog() {
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getStationRegisterFinish());
    }

    public static void printStationRemoveFinishLog() {
        OutputViewComponent.printLogWithWhiteSpace(StationManagementViewComponent.getStationRemoveFinish());
    }

    public static void printStationList(List<Station> stationList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Station station : stationList) {
            stringBuilder.append(StationManagementViewComponent.getFinishPrefix());
            stringBuilder.append(station.getName());
            stringBuilder.append(CommonViewComponent.getWhiteLine());
        }
        System.out.println(stringBuilder.toString());
    }
}
