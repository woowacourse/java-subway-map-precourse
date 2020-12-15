package subway.utils;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    public static void initScanner(Scanner nextScanner) {
        scanner = nextScanner;
    }

    public static String inputSelect() {
        return scanner.nextLine();
    }

    public static String inputName() {
        return scanner.nextLine();
    }

    public static String inputRegisterLineName() {
        System.out.println("등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputUpStationsName() {
        System.out.println("등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDownStationsName() {
        System.out.println("등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDeleteLineName() {
        System.out.println("삭제할 노선 이름을 입력하세요. ");
        return scanner.nextLine();
    }

    public static String inputRegisterStationName() {
        System.out.println("등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDeleteStationName() {
        System.out.println("삭제할 역 이름을 입력하세요. ");
        return scanner.nextLine();
    }

    public static String inputLineName() {
        System.out.println("노선을 입력하세요. ");
        return scanner.nextLine();
    }

    public static String inputStationName() {
        System.out.println("역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static int inputSectionIndex() {
        System.out.println("순서를 입력하세요.");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static String inputDeleteSectionLine() {
        System.out.println("삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputDeleteSectionStation() {
        System.out.println("삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine();
    }
}
