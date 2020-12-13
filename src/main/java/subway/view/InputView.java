package subway.view;

import subway.tool.InputTool;

import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);
    public static String mainInput() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String stationInsertInput() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
    public static String stationDeleteInput() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineNameInsertInput() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineStartInput() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineEndInput() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
    public static String LineDeleteInput() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
}
