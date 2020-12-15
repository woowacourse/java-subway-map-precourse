package subway.screen;

import java.util.Scanner;

interface SubwayScreen {
    String MESSAGE_MENU_SELECT = "\n## 원하는 기능을 선택하세요.";
    String ERROR_MAIN_SCREEN_NOT_VALID_INPUT = "\n[ERROR] 잘못된 기능 입력입니다.";
    String NEW_LINE = "\n";

    void startProcess(Scanner scanner);
    void printScreen();
    void validateInput(Scanner scanner);
    void selectProcess(Scanner scanner, String input);
}
