package subway.view;

import subway.enums.LineInput;

import java.util.Scanner;

public class LineInputView {

    public String lineView(Scanner scanner) {
        System.out.println("## 노선 관리 화면");
        System.out.println(LineInput.getMenu());
        System.out.println("\n## 원하는 기능을 선택하세요.");

        try {
            return LineInput.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 입력이 잘못되었습니다.\n");
            return lineView(scanner);
        }
    }

    public String register (Scanner scanner) {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String remove (Scanner scanner) {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
