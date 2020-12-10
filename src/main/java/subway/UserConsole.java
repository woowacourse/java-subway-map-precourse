package subway;

import java.util.List;
import java.util.Scanner;

public class UserConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INVALID = "INVALID";
    private static final int MINIMUM_LEGNTH = 2;

    // temporary fix
    public static String getInput() {
        return scanner.nextLine();
    }

    public static String getMainCommand(List<String> authorizedCommands) {
        showMainOptions();
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (authorizedCommands.contains(userInput)) {
            return userInput;
        }
        System.out.println("[ERROR] 없는 기능입니다.\n");
        return INVALID;
    }

    private static void showMainOptions() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
    }

    public static String getStationManagerCommand(List<String> authorizedCommands) {
        showStationMangagerOptions();
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (authorizedCommands.contains(userInput)) {
            return userInput;
        }
        System.out.println("[ERROR] 없는 기능입니다.\n");
        return INVALID;
    }

    private static void showStationMangagerOptions() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
    }

    public static String getLineManagerCommand(List<String> authorizedCommands) {
        showLineMangagerOptions();
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (authorizedCommands.contains(userInput)) {
            return userInput;
        }
        System.out.println("[ERROR] 없는 기능입니다.\n");
        return INVALID;
    }

    private static void showLineMangagerOptions() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
    }

    public static String getIntervalManagerCommand(List<String> authorizedCommands) {
        showIntervalMangagerOptions();
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (authorizedCommands.contains(userInput)) {
            return userInput;
        }
        System.out.println("[ERROR] 없는 기능입니다.\n");
        return INVALID;
    }

    private static void showIntervalMangagerOptions() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기\n");
    }
}
