package subway.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String mainInput() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 관리");
        System.out.println("Q. 종료");
        System.out.println("## 원하는 기능을 선택하세요.");
        System.out.println();

        try {
            return scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("입력이 잘못되었습니다.");
            return mainInput();
        }
    }
}
