package subway.view;

import subway.tool.InputTool;

import java.util.Scanner;
public class InputView {
    final static Scanner scanner = new Scanner(System.in);
    final static String ERROR_MESSAGE = "[ERROR] 선택할 수 없는 기능입니다.";
    public static String mainInput() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String user_input = scanner.nextLine();
        if(InputTool.isMainInputVaild(user_input) == false) throw new IllegalArgumentException(ERROR_MESSAGE);
        return user_input;
    }
}
