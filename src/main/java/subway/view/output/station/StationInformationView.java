package subway.view.output.station;

import subway.type.InformationType;

/**
 * StationInformationView.java : 지하철 역 실행 결과 문구 출력에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
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
