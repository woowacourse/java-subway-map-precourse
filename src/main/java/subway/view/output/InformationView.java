package subway.view.output;

import subway.type.InformationType;

public class InformationView {
    public static void printStationAddingInformation() {
        System.out.println();
        System.out.println(InformationType.STATION_ADDING_INFORMATION.getInformation());
    }
}
