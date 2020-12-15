package subway.view.output.station;

import subway.type.InformationType;

public class StationInformationView {
    public static void printStationAdditionInformation() {
        System.out.println();
        System.out.println(InformationType.STATION_ADDITION_INFORMATION.getInformation());
    }

    public static void printStationDeletionInformation() {
        System.out.println();
        System.out.println(InformationType.STATION_DELETION_INFORMATION.getInformation());
    }
}
