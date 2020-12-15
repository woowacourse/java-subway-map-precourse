package subway.manager;

import java.util.Scanner;
import subway.validator.SectionManagerValidator;

public class SectionManager {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_LINE_MESSAGE = "## 노선 이름을 입력하세요.";
    public static final String INPUT_STATION_MESSAGE = "## 역 이름을 입력하세요.";
    public static final String INPUT_ORDER_MESSAGE = "## 순서를 입력하세요.";
    public static final String INFO_PREFIX = "[INFO] ";
    public static final String ENROLLMENT_SECTION_INFO_MESSAGE = "구간이 등록되었습니다";
    public static final String ASK_LINE_DELETION_MESSAGE = "## 삭제할 구간의 노선을 입력하세요.";
    public static final String ASK_STATION_DELETION_MESSAGE = "## 삭제할 구간의 역을 입력하세요.";
    public static final String DELETION_SECTION_MESSAGE = "구간이 삭제되었습니다";
    public static final String DELETION_FAIL_INFO_MESSAGE = "존재하지 않거나 삭제할 수 없습니다";

    public void enrollSection(Scanner scanner) {
        System.out.println(INPUT_LINE_MESSAGE);
        String lineName = inputLineNameForSection(scanner);
        System.out.println(INPUT_STATION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        System.out.println(INPUT_ORDER_MESSAGE);
        int order = inputOrderForEnrollment(scanner);
        SubwayManager.addSection(lineName, stationName, order);
        System.out.println();
        System.out.println(INFO_PREFIX + ENROLLMENT_SECTION_INFO_MESSAGE);
        System.out.println();
    }

    public static String inputLineNameForSection(Scanner scanner) {
        String lineName = scanner.nextLine();
        try {
            SectionManagerValidator.validateLineNameForEnrollment(lineName);
            return lineName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputLineNameForSection(scanner);
        }
    }

    public static String inputStationNameForEnrollment(Scanner scanner) {
        String stationName = scanner.nextLine();
        try {
            SectionManagerValidator.validateStationNameForEnrollment(stationName);
            return stationName;
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputStationNameForEnrollment(scanner);
        }
    }

    public static int inputOrderForEnrollment(Scanner scanner) {
        String order = scanner.nextLine();
        try {
            SectionManagerValidator.validateOrderForEnrollment(order);
            return Integer.parseInt(order);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_PREFIX + iae.getMessage());
            return inputOrderForEnrollment(scanner);
        }
    }

    public void deleteSection(Scanner scanner) {
        System.out.println(ASK_LINE_DELETION_MESSAGE);
        String lineName = inputLineNameForSection(scanner);
        System.out.println(ASK_STATION_DELETION_MESSAGE);
        String stationName = inputStationNameForEnrollment(scanner);
        if (SubwayManager.deleteSection(lineName, stationName)) {
            System.out.println(INFO_PREFIX + DELETION_SECTION_MESSAGE);
            System.out.println();
            return;
        }
        System.out.println(INFO_PREFIX + DELETION_FAIL_INFO_MESSAGE);
        System.out.println();
    }
}
