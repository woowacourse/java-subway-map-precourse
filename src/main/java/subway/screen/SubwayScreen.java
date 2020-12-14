package subway.screen;

import java.util.Scanner;

interface SubwayScreen {
    String MESSAGE_MENU_SELECT = "\n## 원하는 기능을 선택하세요.";
    String ERROR_MAIN_SCREEN_NOT_VALID_INPUT = "[ERROR] 잘못된 기능 입력입니다.";

    void startProcess(Scanner scanner);
    void printScreen();
    String validateInput(String input);
    void transfer(Scanner scanner);
}
