package subway;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class InputView {
    public static final String MSG_INVOKE_USER_INPUT = "\n## 원하는 기능을 선택하세요.";
    public static final String ERROR_MSG_NON_EXISTING_MENU = "\n[ERROR] 올바른 입력을 해주세요";
    public static final String SCREE_MAIN_MENU = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 출력";
    public static final String SCREEN_STATION_MANAGER = "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기";
    public static final String SCREEN_LINE_MANAGER = "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB 돌아가기";
    public static final String SCREEN_SECTION_MANAGER = "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기";
    public static final String KEY_MAIN = "main";
    public static final String KEY_STATION = "stationManager";
    public static final String KEY_LINE = "lineManager";
    public static final String KEY_SECTION = "sectionManager";
    public static final String REGEX_MAIN_MENU = "[1-4Qq]";
    public static final String REGEX_STATION_MANAGER = "[1-3Bb]";
    public static final String REGEX_LINE_MANAGER = "[1-3Bb]";
    public static final String REGEX_SECTION_MANAGER = "[1-2Bb]";
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
        menuByScreen.put(KEY_MAIN, SCREE_MAIN_MENU);
        menuByScreen.put(KEY_STATION, SCREEN_STATION_MANAGER);
        menuByScreen.put(KEY_LINE, SCREEN_LINE_MANAGER);
        menuByScreen.put(KEY_SECTION, SCREEN_SECTION_MANAGER);
    }

    public void makeRegex() {
        validMenuRegex = new HashMap<>();
        validMenuRegex.put(KEY_MAIN, REGEX_MAIN_MENU);
        validMenuRegex.put(KEY_STATION, REGEX_STATION_MANAGER);
        validMenuRegex.put(KEY_LINE, REGEX_LINE_MANAGER);
        validMenuRegex.put(KEY_SECTION, REGEX_SECTION_MANAGER);
    }

    public String nextMenu() {
        printMenuScreen();
        return parseMenuNumber();
    }

    public void printMenuScreen() {
        System.out.println(menuByScreen.get(screenName));
        System.out.println(MSG_INVOKE_USER_INPUT);
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
            throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_MENU);
        }
        return userInput;
    }

    public static String askName(Scanner scanner) {
        return scanner.nextLine().trim();
    }

}
