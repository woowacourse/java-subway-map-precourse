package subway.view;

import subway.enums.LineInput;
import subway.enums.MainInput;
import subway.enums.SectionInput;

import java.util.Scanner;

public class MainInputView {

    private static final String newLine = "\n";
    private final Scanner SCANNER;

    public MainInputView(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public String mainView() {
        System.out.println("## 메인 화면");
        System.out.println(MainInput.getMenu());
        System.out.println(newLine + "## 원하는 기능을 선택하세요.");

        try {
            return MainInput.validateInput(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(newLine + "[ERROR] 입력이 잘못되었습니다." + newLine);
            return mainView();
        }
    }

}
