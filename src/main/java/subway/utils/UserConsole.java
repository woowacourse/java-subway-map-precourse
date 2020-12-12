package subway.utils;

import java.util.List;
import java.util.Scanner;

public class UserConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String MAIN = "MAIN";
    private static final String STATION_MANAGER = "STATION MANAGER";
    private static final String LINE_MANAGER = "LINE MANAGER";
    private static final String INTERVAL_MANAGER = "INTERVAL MANAGER";

    public static String getCommand(String placeOfCommand, List<String> authorizedCommands) throws IllegalArgumentException {
        showOptions(placeOfCommand);
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();
        if (!authorizedCommands.contains(userInput)) {
            System.out.println("[ERROR] 없는 기능입니다.\n");
            throw new IllegalArgumentException();
        }
        return userInput;
    }

    private static void showOptions(String placeOfCommand) {
        if (placeOfCommand.equals(MAIN)) {
            showMainOptions();
        }
        if (placeOfCommand.equals(STATION_MANAGER)) {
            showStationMangagerOptions();
        }
        if (placeOfCommand.equals(LINE_MANAGER)) {
            showLineMangagerOptions();
        }
        if (placeOfCommand.equals(INTERVAL_MANAGER)) {
            showIntervalMangagerOptions();
        }
    }

    private static void showMainOptions() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료\n");
    }

    private static void showStationMangagerOptions() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기\n");
    }

    private static void showLineMangagerOptions() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기\n");
    }

    private static void showIntervalMangagerOptions() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기\n");
    }

    public static String getName() throws IllegalArgumentException {
        String name = scanner.nextLine();
        System.out.println();
        if (!Validator.isAppropriateLength(name)) {
            throw new IllegalArgumentException();
        }
        return name;
    }

    public static int getZeroOrNaturalNumber() throws IllegalArgumentException {
        String index = scanner.nextLine();
        System.out.println();
        if (!Validator.isZeroOrNaturalNumber(index)) {
            System.out.println("\n[ERROR] 순서는 자연수이어야 한다");
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(index);
    }
}
