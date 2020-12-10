package subway.view;

import subway.enums.StationInput;

import java.util.Scanner;

public class StationInputView {

    public String stationView(Scanner scanner) {
        System.out.println("## 역 관리 화면");
        System.out.println(StationInput.getMenu());
        System.out.println("## 원하는 기능을 선택하세요.");

        try {
            return StationInput.validateInput(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] 입력이 잘못되었습니다.\n");
            return stationView(scanner);
        }
    }

    public String register (Scanner scanner) {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public String remove (Scanner scanner) {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

}
