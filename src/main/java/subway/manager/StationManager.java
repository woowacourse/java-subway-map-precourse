package subway.manager;

import java.util.Scanner;
import subway.validator.StationManagerValidator;
import view.StationManagerView;

public class StationManager {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String INPUT_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    public static final String ENROLLMENT_STATION_INFO_MESSAGE = "지하철 역이 등록되었습니다";
    public static final String ASK_DELETION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    public static final String DELETION_INFO_MESSAGE = "지하철 역이 삭제되었습니다";
    public static final String DELETION_FAIL_INFO_MESSAGE = "지하철 역이 존재하지 않거나 삭제할 수 없습니다";

    public static String inputStationNameForEnrollment(Scanner scanner) {
        String stationName = scanner.nextLine();
        try {
            StationManagerValidator.validateStationNameForEnrollment(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForEnrollment(scanner);
        }
    }

    public static String inputStationNameForDeletion(Scanner scanner) {
        String stationName = scanner.nextLine();
        try {
            StationManagerValidator.validateStationNameForDeletion(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForDeletion(scanner);
        }
    }

    public void enrollStation(Scanner scanner) {
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        SubwayManager.addStation(stationName);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_STATION_INFO_MESSAGE);
        System.out.println();
    }

    public void deleteStation(Scanner scanner) {
        System.out.println(ASK_DELETION_MESSAGE);
        String stationName = inputStationNameForDeletion(scanner);
        if (SubwayManager.deleteStation(stationName)) {
            System.out.println(INFO_PREFIX + DELETION_INFO_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(INFO_PREFIX + DELETION_FAIL_INFO_MESSAGE);
        System.out.println();
    }

    public static void searchStation(Scanner scanner) {
        SubwayManager.printStation();
    }
}
