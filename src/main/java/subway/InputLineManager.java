package subway;

import java.util.Arrays;
import java.util.Scanner;

public class InputLineManager implements InputManager {
    private static final String LINE_MAIN_MENU = "## 노선 관리 화면\n1. 노선 등록\n" +
                                                    "2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";

    private Scanner scanner;

    private enum Menu {
        REGISTER("1"),
        DELETE("2"),
        INQUIRY("3"),
        BACK("B");

        private final String name;
        Menu(String name) {
            this.name = name;
        }
        public static void execute(String input) {
            Arrays.stream(values())
                    .filter(value -> value.name.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_STATE_TRY_AGAIN));
        }
    }

    public InputLineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(LINE_MAIN_MENU);
            String state = scanner.next();
            Menu.execute(state);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    @Override
    public void register() {

    }

    @Override
    public void delete() {

    }

}
