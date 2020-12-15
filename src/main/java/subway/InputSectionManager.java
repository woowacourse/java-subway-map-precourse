package subway;

import java.util.Arrays;
import java.util.Scanner;

public class InputSectionManager implements InputManager {
    private static final String SECTION_MAIN_MENU = "## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";

    private Scanner scanner;

    private enum Menu {
        REGISTER("1"),
        DELETE("2"),
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

    public InputSectionManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(SECTION_MAIN_MENU);
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
