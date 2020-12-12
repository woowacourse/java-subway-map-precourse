package subway.view;

import subway.domain.type.ManagementType;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_MANAGEMENT_FUNCTION_NOTICE = "\n## 원하는 기능을 선택하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public ManagementType inputManagementType() {
        System.out.println(INPUT_MANAGEMENT_FUNCTION_NOTICE);
        String managementNumber = scanner.nextLine();
        try {
            return ManagementType.findManagementType(managementNumber);
        } catch (RuntimeException runtimeException) {
            OutputView.printErrorMessage(runtimeException);
            return inputManagementType();
        }
    }
}
