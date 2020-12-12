package subway.view;

import util.validator.Validation;

import java.util.Scanner;

public class InputView {
    private static final String MAIN_CONTROLLER_INFORMATION = "## 메인 화면\n1. 역관리\n2. 노선관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n";
    private static final String MAIN_CONTROLLER_GIVE_OPTION = "## 원하는 기능을 선택하세요.";

    public static String mainControllerInput(Scanner scanner) {
        System.out.println(MAIN_CONTROLLER_INFORMATION);
        String userInput = null;
        boolean properInput = false;
        while (!properInput) {
            System.out.println(MAIN_CONTROLLER_GIVE_OPTION);
            userInput = scanner.nextLine();
            properInput = Validation.checkMainControllerInput(userInput);
        }
        return userInput;
    }
}
