package subway.view;

import subway.domain.entity.InvalidSectionOrderException;
import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;
import subway.dto.LineDto;
import subway.dto.SectionDto;

import java.util.Scanner;

public class InputView {
    private static final String MANAGEMENT_FUNCTION_NUMBER_NOTICE = "\n## 원하는 기능을 선택하세요.";
    private static final String STATION_NAME_REGISTRATION_NOTICE = "\n## 등록할 역 이름을 입력하세요.";
    private static final String STATION_NAME_DELETION_NOTICE = "\n## 삭제할 역 이름을 입력하세요.";
    private static final String LINE_NAME_REGISTRATION_NOTICE = "\n## 등록할 노선 이름을 입력하세요.";
    private static final String LINE_NAME_DELETION_NOTICE = "\n## 삭제할 노선 이름을 입력하세요.";
    private static final String UPWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_LINE_NAME_NOTICE = "\n## 노선을 입력하세요.";
    private static final String SECTION_REGISTRATION_STATION_NAME_NOTICE = "\n## 역이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_ORDER_NUMBER_NOTICE = "\n## 순서를 입력하세요.";
    private static final String SECTION_DELETION_LINE_NAME_NOTICE = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String SECTION_DELETION_STATION_NAME_NOTICE = "\n## 삭제할 구간의 역을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ManagementType inputManagementType() {
        String managementNumber = scanInputLineWithNotice(MANAGEMENT_FUNCTION_NUMBER_NOTICE);
        try {
            return ManagementType.findManagementType(managementNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputManagementType();
        }
    }

    private String scanInputLineWithNotice(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public FunctionType inputFunctionType(ManagementType managementType) {
        String functionNumber = scanInputLineWithNotice(MANAGEMENT_FUNCTION_NUMBER_NOTICE);
        try {
            return managementType.findFunctionType(functionNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputFunctionType(managementType);
        }
    }

    public String inputStationName(FunctionType functionType) {
        if (functionType == FunctionType.DELETE) {
            return scanInputLineWithNotice(STATION_NAME_DELETION_NOTICE);
        }
        return scanInputLineWithNotice(STATION_NAME_REGISTRATION_NOTICE);
    }

    public LineDto inputLineRequest(FunctionType functionType) {
        if (functionType == FunctionType.DELETE) {
            String lineName = scanInputLineWithNotice(LINE_NAME_DELETION_NOTICE);
            return new LineDto(lineName);
        }
        String lineName = scanInputLineWithNotice(LINE_NAME_REGISTRATION_NOTICE);
        String upwardLastStationName = scanInputLineWithNotice(UPWARD_LAST_STATION_NAME_NOTICE);
        String downwardLastStationName = scanInputLineWithNotice(DOWNWARD_LAST_STATION_NAME_NOTICE);
        return new LineDto(lineName, upwardLastStationName, downwardLastStationName);
    }

    public SectionDto inputSectionRequest(FunctionType functionType) {
        if (functionType == FunctionType.DELETE) {
            String lineName = scanInputLineWithNotice(SECTION_DELETION_LINE_NAME_NOTICE);
            String stationName = scanInputLineWithNotice(SECTION_DELETION_STATION_NAME_NOTICE);
            return new SectionDto(lineName, stationName);
        }
        String lineName = scanInputLineWithNotice(SECTION_REGISTRATION_LINE_NAME_NOTICE);
        String stationName = scanInputLineWithNotice(SECTION_REGISTRATION_STATION_NAME_NOTICE);
        int sectionOrderNumber = scanSectionOrderNumber();
        return new SectionDto(lineName, stationName, sectionOrderNumber);
    }

    private int scanSectionOrderNumber() {
        String sectionOrderNumber = scanInputLineWithNotice(SECTION_REGISTRATION_ORDER_NUMBER_NOTICE);
        validateNumberFormat(sectionOrderNumber);
        return Integer.parseInt(sectionOrderNumber);
    }

    private void validateNumberFormat(String sectionOrderNumber) {
        boolean isNumberFormat = sectionOrderNumber.chars()
                .allMatch(Character::isDigit);
        if (!isNumberFormat) {
            throw new InvalidSectionOrderException();
        }
    }
}
