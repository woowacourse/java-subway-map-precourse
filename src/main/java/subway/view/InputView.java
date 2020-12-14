package subway.view;

import subway.domain.type.FunctionType;
import subway.domain.type.ManagementType;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MANAGEMENT_FUNCTION_NUMBER_NOTICE = "\n## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ManagementType inputManagementType() {
        String managementNumber = inputManagementFunctionNumber();
        try {
            return ManagementType.findManagementType(managementNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputManagementType();
        }
    }

    public FunctionType inputFunctionType(ManagementType managementType) {
        String functionNumber = inputManagementFunctionNumber();
        try {
            return managementType.findFunctionType(functionNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputFunctionType(managementType);
        }
    }

    public String inputManagementFunctionNumber() {
        System.out.println(INPUT_MANAGEMENT_FUNCTION_NUMBER_NOTICE);
        return scanner.nextLine();
    }

    public String inputStationName(FunctionType functionType) {
        if (functionType == FunctionType.REGISTER) {
            System.out.println("\n## 등록할 역 이름을 입력하세요.");
        }
        if (functionType == FunctionType.DELETE) {
            System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        }
        return scanner.nextLine();
    }
}
