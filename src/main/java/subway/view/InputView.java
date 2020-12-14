package subway.view;

import subway.domain.entity.InvalidSectionOrderException;
import subway.dto.LineDto;
import subway.dto.SectionDto;
import subway.vo.FunctionType;
import subway.vo.ManagementType;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final String MANAGEMENT_FUNCTION_NUMBER_NOTICE = "\n## 원하는 기능을 선택하세요.";
    private static final String INPUT_NAME_MESSAGE_FORMAT = "\n## %s할 %s 이름을 입력하세요.";
    private static final String UPWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String DOWNWARD_LAST_STATION_NAME_NOTICE = "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_LINE_NAME_NOTICE = "\n## 노선을 입력하세요.";
    private static final String SECTION_REGISTRATION_STATION_NAME_NOTICE = "\n## 역이름을 입력하세요.";
    private static final String SECTION_REGISTRATION_ORDER_NUMBER_NOTICE = "\n## 순서를 입력하세요.";
    private static final String SECTION_DELETION_LINE_NAME_NOTICE = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String SECTION_DELETION_STATION_NAME_NOTICE = "\n## 삭제할 구간의 역을 입력하세요.";
    private static InputView inputView;

    private Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initiate(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public static InputView getInstance() {
        if (Objects.isNull(inputView)) {
            throw new CannotReturnInputViewException();
        }
        return inputView;
    }

    public ManagementType inputManagementType() {
        String managementNumber = scanInputWithNoticeMessage(MANAGEMENT_FUNCTION_NUMBER_NOTICE);
        try {
            return ManagementType.findManagementType(managementNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputManagementType();
        }
    }

    private String scanInputWithNoticeMessage(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public FunctionType inputFunctionType(ManagementType managementType) {
        String functionNumber = scanInputWithNoticeMessage(MANAGEMENT_FUNCTION_NUMBER_NOTICE);
        try {
            return managementType.findFunctionType(functionNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputFunctionType(managementType);
        }
    }

    public String inputName(ManagementType managementType, FunctionType functionType) {
        String message = String.format(INPUT_NAME_MESSAGE_FORMAT, functionType.toString(), managementType.toString());
        return scanInputWithNoticeMessage(message);
    }

    public LineDto inputLineRequest(ManagementType managementType, FunctionType functionType) {
        String lineName = inputName(managementType, functionType);
        String upwardLastStationName = scanInputWithNoticeMessage(UPWARD_LAST_STATION_NAME_NOTICE);
        String downwardLastStationName = scanInputWithNoticeMessage(DOWNWARD_LAST_STATION_NAME_NOTICE);
        return new LineDto(lineName, upwardLastStationName, downwardLastStationName);
    }

    public SectionDto inputSectionRequest(FunctionType functionType) {
        if (functionType == FunctionType.DELETE) {
            String lineName = scanInputWithNoticeMessage(SECTION_DELETION_LINE_NAME_NOTICE);
            String stationName = scanInputWithNoticeMessage(SECTION_DELETION_STATION_NAME_NOTICE);
            return new SectionDto(lineName, stationName);
        }
        String lineName = scanInputWithNoticeMessage(SECTION_REGISTRATION_LINE_NAME_NOTICE);
        String stationName = scanInputWithNoticeMessage(SECTION_REGISTRATION_STATION_NAME_NOTICE);
        int sectionOrderNumber = inputSectionOrderNumber();
        return new SectionDto(lineName, stationName, sectionOrderNumber);
    }

    private int inputSectionOrderNumber() {
        String sectionOrderNumber = scanInputWithNoticeMessage(SECTION_REGISTRATION_ORDER_NUMBER_NOTICE);
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
