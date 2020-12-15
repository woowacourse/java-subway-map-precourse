package subway.manager;

import java.util.Scanner;
import subway.system.helper.LineSystemInputValidator;

public class LineManager {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    public static final String INPUT_UPWARD_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_DOWNWARD_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ENROLLMENT_LINE_INFO_MESSAGE = "지하철 노선이 등록되었습니다";
    public static final String ASK_DELETION_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    public static final String DELETION_INFO_MESSAGE = "지하철 노선이 삭제되었습니다";
    public static final String DELETION_FAIL_MESSAGE = "지하철 노선이 존재하지 않거나 삭제할 수 없습니다";


    public void enrollLine(Scanner scanner) {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputLineNameForEnrollment(scanner);
        System.out.println(INPUT_UPWARD_MESSAGE);
        String upwardStationName = inputStationNameForEnrollment(scanner);
        System.out.println(INPUT_DOWNWARD_MESSAGE);
        String downwardStationName = inputStationNameForEnrollment(scanner);
        SubwayManager.addLine(lineName, upwardStationName, downwardStationName);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_LINE_INFO_MESSAGE);
        System.out.println();
    }

    public static String inputLineNameForEnrollment(Scanner scanner) {
        String lineName = scanner.nextLine().trim();
        try {
            LineSystemInputValidator.validateLineNameForEnrollment(lineName);
            return lineName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputLineNameForEnrollment(scanner);
        }
    }

    public static String inputStationNameForEnrollment(Scanner scanner) {
        String stationName = scanner.nextLine().trim();
        try {
            LineSystemInputValidator.validateStationNameForEnrollment(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForEnrollment(scanner);
        }
    }

    public void deleteLine(Scanner scanner) {
        System.out.println(ASK_DELETION_MESSAGE);
        String lineName = inputLineNameForDeletion(scanner);
        if (SubwayManager.deleteLine(lineName)) {
            System.out.println(INFO_PREFIX + DELETION_INFO_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(INFO_PREFIX + DELETION_FAIL_MESSAGE);
        System.out.println();
    }

    public static String inputLineNameForDeletion(Scanner scanner) {
        String lineName = scanner.nextLine().trim();
        try {
            LineSystemInputValidator.validateStationNameForDeletion(lineName);
            return lineName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputLineNameForDeletion(scanner);
        }
    }


    public static void searchLine(Scanner scanner) {
        SubwayManager.printLine();
    }
}
