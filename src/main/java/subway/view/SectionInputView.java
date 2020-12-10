package subway.view;

import subway.enums.SectionInput;

import java.util.Scanner;

public class SectionInputView {

    public String sectionView(Scanner scanner) {
        System.out.println("## 구간 관리 화면");
        System.out.println(SectionInput.getMenu());
        System.out.println("\n## 원하는 기능을 선택하세요.");

        try {
            return SectionInput.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 입력이 잘못되었습니다.\n");
            return sectionView(scanner);
        }
    }

    public String register (Scanner scanner) {
        System.out.println("## 등록할 구간 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String remove (Scanner scanner) {
        System.out.println("## 삭제할 구간 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
