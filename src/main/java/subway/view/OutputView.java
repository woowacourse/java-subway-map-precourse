package subway.view;

import subway.dto.SubwayMapDto;
import subway.type.FunctionType;
import subway.type.ManagementType;

import java.util.List;

public class OutputView {
    private static final String MAIN_DISPLAY =
            "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String STATION_MANAGEMENT_DISPLAY =
            "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    private static final String LINE_MANAGEMENT_DISPLAY =
            "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기";
    private static final String SECTION_MANAGEMENT_DISPLAY =
            "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    private static final String EMPTY_DATA_MESSAGE = "등록된 데이터가 없어 출력이 불가능합니다.";
    private static final String SUBWAY_MAP_PRINT_HEADER = "\n## 지하철 노선도";
    private static final String SUBWAY_MAP_DELIMITER = "\n[INFO] ---";
    private static final String INFORMATION_SUCCESS_MESSAGE_FORMAT = "\n[INFO] 지하철 %s이 %s되었습니다.\n";
    private static final String INFORMATION_MESSAGE_FORMAT = "\n[INFO] %s";
    private static final String ERROR_MESSAGE_FORMAT = "\n[ERROR] %s\n";
    private static final String NAMES_PRINT_HEADER_FORMAT = "\n## %s 목록";

    private OutputView() {
    }

    public static void printMainDisplay() {
        System.out.println(MAIN_DISPLAY);
    }

    public static void printManagementDisplay(ManagementType managementType) {
        String managementDisplay = getManagementDisplay(managementType);
        System.out.println(managementDisplay);
    }

    private static String getManagementDisplay(ManagementType managementType) {
        if (managementType == ManagementType.STATION) {
            return STATION_MANAGEMENT_DISPLAY;
        }
        if (managementType == ManagementType.LINE) {
            return LINE_MANAGEMENT_DISPLAY;
        }
        return SECTION_MANAGEMENT_DISPLAY;
    }

    public static void printErrorMessage(RuntimeException runtimeException) {
        System.out.printf(ERROR_MESSAGE_FORMAT, runtimeException.getMessage());
    }

    public static void printSuccessMessage(ManagementType managementType, FunctionType functionType) {
        System.out.printf(INFORMATION_SUCCESS_MESSAGE_FORMAT, managementType.toString(), functionType.toString());
    }

    public static void printNames(ManagementType managementType, List<String> names) {
        if (names.isEmpty()) {
            System.out.printf(ERROR_MESSAGE_FORMAT, EMPTY_DATA_MESSAGE);
            return;
        }
        System.out.printf(NAMES_PRINT_HEADER_FORMAT, managementType.toString());
        names.forEach(name -> System.out.printf(INFORMATION_MESSAGE_FORMAT, name));
        System.out.println();
    }

    public static void printSubwayMap(List<SubwayMapDto> subwayMapDtos) {
        if (subwayMapDtos.isEmpty()) {
            System.out.printf(ERROR_MESSAGE_FORMAT, EMPTY_DATA_MESSAGE);
            return;
        }
        System.out.print(SUBWAY_MAP_PRINT_HEADER);
        subwayMapDtos.forEach(OutputView::printSubwayMapOfEachLine);
    }

    public static void printSubwayMapOfEachLine(SubwayMapDto subwayMapDto) {
        String lineName = subwayMapDto.getLineName();
        System.out.printf(INFORMATION_MESSAGE_FORMAT, lineName);
        System.out.print(SUBWAY_MAP_DELIMITER);
        subwayMapDto.getStationNames()
                .forEach(stationName -> System.out.printf(INFORMATION_MESSAGE_FORMAT, stationName));
        System.out.println();
    }
}
