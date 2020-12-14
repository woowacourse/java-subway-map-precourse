package subway;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class InputView {
    public Map<String, String> menuByScreen;
    public Map<String, String> validMenuRegex;
    private Scanner scanner;
    private String screenName;


    public InputView(Scanner scanner, String screenName) {
        this.scanner = scanner;
        this.screenName = screenName;
        makeScreen();
        makeRegex();
    }


    public void makeScreen() {
        menuByScreen = new HashMap<>();
        menuByScreen.put("main", "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 출력");
        menuByScreen.put("stationManager", "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기");
        menuByScreen.put("lineManager", "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB 돌아가기");
        menuByScreen.put("sectionManager", "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기");
    }

    public void makeRegex() {
        validMenuRegex = new HashMap<>();
        validMenuRegex.put("main", "[1-4Qq]");
        validMenuRegex.put("stationManager", "[1-3Bb]");
        validMenuRegex.put("lineManager", "[1-3Bb]");
        validMenuRegex.put("sectionManager", "[1-2Bb]");
    }

    public String nextMenu() {
        printMenuScreen();
        return parseMenuNumber();
    }

    public void printMenuScreen() {
        System.out.println(menuByScreen.get(screenName));
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public String parseMenuNumber() {
        String userInput = scanner.nextLine();
        try {
            return menuInputNumber(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return nextMenu();
        }
    }

    public String menuInputNumber(String userInput) {
        if (!userInput.matches(validMenuRegex.get(screenName))) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력을 해주세요");
        }
        return userInput;
    }

    public static String askName(Scanner scanner) {
        return scanner.nextLine();
    }

}
