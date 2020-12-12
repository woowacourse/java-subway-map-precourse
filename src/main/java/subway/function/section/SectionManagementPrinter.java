package subway.function.section;

import subway.commonprint.Prefix;

public class SectionManagementPrinter {
    private static final String LINE_NAME_TO_REGISTER_SECTION_INPUT_MESSAGE
        = "\n## 노선을 입력하세요.";
    private static final String STATION_NAME_TO_REGISTER_SECTION_INPUT_MESSAGE
        = "\n## 역이름을 입력하세요.";
    private static final String ORDER_TO_REGISTER_SECTION_INPUT_MESSAGE
        = "\n## 순서를 입력하세요.";
    private static final String SECTION_REGISTRATION_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "구간이 등록되었습니다.";
    private static final String LINE_NAME_TO_DELETE_SECTION_INPUT_MESSAGE
        = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String STATION_NAME_TO_DELETE_SECTION_INPUT_MESSAGE
        = "\n## 삭제할 구간의 역을 입력하세요.";
    private static final String SECTION_DELETE_SUCCESS_MESSAGE
        = "\n" + Prefix.INFO_PREFIX + "구간이 삭제되었습니다.";

    public static void printLineNameToRegisterSectionInputMessage() {
        System.out.println(LINE_NAME_TO_REGISTER_SECTION_INPUT_MESSAGE);
    }

    public static void printStationNameToRegisterSectionInputMessage() {
        System.out.println(STATION_NAME_TO_REGISTER_SECTION_INPUT_MESSAGE);
    }

    public static void printOrderToRegisterInputMessage() {
        System.out.println(ORDER_TO_REGISTER_SECTION_INPUT_MESSAGE);
    }

    public static void printSectionRegistrationSuccessMessage() {
        System.out.println(SECTION_REGISTRATION_SUCCESS_MESSAGE);
    }

    public static void printLineNameToDeleteSectionInputMessage() {
        System.out.println(LINE_NAME_TO_DELETE_SECTION_INPUT_MESSAGE);
    }

    public static void printStationNameToDeleteSectionInputMessage() {
        System.out.println(STATION_NAME_TO_DELETE_SECTION_INPUT_MESSAGE);
    }

    public static void printSectionDeleteSuccessMessage() {
        System.out.println(SECTION_DELETE_SUCCESS_MESSAGE);
    }
}
